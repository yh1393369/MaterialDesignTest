package com.rookie.www.materialdesigntest;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

public class CardActivity extends AppCompatActivity {

    public static final String CARD_NAME = "card_name";
    public static final String IMAGE_ID = "image_id";

    private static final String CONTENT = "《水浒传》，是中国四大名著之一，全书描写北宋末年以宋江为首的108位好汉在梁山聚义，以及聚义之后接受招安、四处征战的故事。\n" +
            "《水浒传》也是汉语文学中最具备史诗特征的作品之一。[1]  是中国历史上最早用白话文写成的章回小说之一。版本众多，流传极广，脍炙人口，对中国乃至东亚的叙事文学都有极其深远的影响。\n" +
            "《水浒传》是一部以描写古代农民起义为题材的长篇小说。它形象地描绘了农民起义从发生、发展直至失败的全过程，深刻揭示了起义的社会根源，满腔热情地歌颂了起义英雄的反抗斗争和他们的社会理想，也具体揭示了起义失败的内在历史原因。";

    private static final int PERMISSION_REQUESTCODE = 1;
    private static final int TAKE_PHOTO = 2;
    private static final String AUTHORITY_OUTPUT_IMAGE = "com.rookie.www.materialdesigntest.fileprovider";

    private Toolbar tbCard;
    private CollapsingToolbarLayout ctblCard;
    private ImageView ivCard;
    private TextView tvCard;
    private FloatingActionButton fabCard;

    private File outputImage;
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        final Intent intent = getIntent();
        String cardName = intent.getStringExtra(CARD_NAME);
        int imageId = intent.getIntExtra(IMAGE_ID, 0);
        tbCard = (Toolbar) findViewById(R.id.tbCard);
        setSupportActionBar(tbCard);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ctblCard = (CollapsingToolbarLayout) findViewById(R.id.ctblCard);
        ctblCard.setTitle(cardName);
        ivCard = (ImageView) findViewById(R.id.ivCard);
        Glide.with(this).load(imageId).into(ivCard);
        tvCard = (TextView) findViewById(R.id.tvCard);
        tvCard.setText(CONTENT);
        fabCard = (FloatingActionButton) findViewById(R.id.fabCard);
        fabCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (ActivityCompat.checkSelfPermission(CardActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CardActivity.this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.SEND_SMS}, PERMISSION_REQUESTCODE);
                } else {
                    call();
                }*/
                outputImage = new File(getExternalCacheDir(), "output_image.jpg");
                try {
                    if(outputImage.exists()){
                        outputImage.delete();
                    }
                    outputImage.createNewFile();
                    if(Build.VERSION.SDK_INT >= 24){
                        imageUri = FileProvider.getUriForFile(CardActivity.this, AUTHORITY_OUTPUT_IMAGE, outputImage);
                    }else {
                        imageUri = Uri.fromFile(outputImage);
                    }
                    Intent imageCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    imageCaptureIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                    startActivityForResult(imageCaptureIntent, TAKE_PHOTO);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case TAKE_PHOTO :
                if(resultCode == RESULT_OK){
                    if(outputImage.exists()){
                        Glide.with(this).load(outputImage).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).centerCrop().into(ivCard);
                        //ivCard.setImageBitmap(BitmapFactory.decodeFile(outputImage.getAbsolutePath()));
                    }
                }
                break;
        }
    }

    /*private void call() {
        try {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:10086"));
            startActivity(callIntent);
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }*/

    /*@Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUESTCODE:
                String permissionsString = "";
                String grantResultsString = "";
                for (int i = 0; i < permissions.length; i++) {
                    permissionsString += permissions[i];
                }
                for (int i = 0; i < grantResults.length; i++) {
                    grantResultsString += String.valueOf(grantResults[i]);
                }
                Log.i("Permissions", permissionsString);
                Log.i("GrantResults", grantResultsString);
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    call();
                } else {
                    Toast.makeText(CardActivity.this, "您未授权使用该功能", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
