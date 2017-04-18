package com.rookie.www.materialdesigntest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class CardActivity extends AppCompatActivity {

    public static final String CARD_NAME = "card_name";
    public static final String IMAGE_ID = "image_id";

    private static final String content = "《水浒传》，是中国四大名著之一，全书描写北宋末年以宋江为首的108位好汉在梁山聚义，以及聚义之后接受招安、四处征战的故事。\n" +
            "《水浒传》也是汉语文学中最具备史诗特征的作品之一。[1]  是中国历史上最早用白话文写成的章回小说之一。版本众多，流传极广，脍炙人口，对中国乃至东亚的叙事文学都有极其深远的影响。\n" +
            "《水浒传》是一部以描写古代农民起义为题材的长篇小说。它形象地描绘了农民起义从发生、发展直至失败的全过程，深刻揭示了起义的社会根源，满腔热情地歌颂了起义英雄的反抗斗争和他们的社会理想，也具体揭示了起义失败的内在历史原因。";

    private Toolbar tbCard;
    private CollapsingToolbarLayout ctblCard;
    private ImageView ivCard;
    private TextView tvCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);
        Intent intent = getIntent();
        String cardName = intent.getStringExtra(CARD_NAME);
        int imageId = intent.getIntExtra(IMAGE_ID, 0);
        tbCard = (Toolbar) findViewById(R.id.tbCard);
        setSupportActionBar(tbCard);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        ctblCard = (CollapsingToolbarLayout) findViewById(R.id.ctblCard);
        ctblCard.setTitle(cardName);
        ivCard = (ImageView) findViewById(R.id.ivCard);
        Glide.with(this).load(imageId).into(ivCard);
        tvCard = (TextView) findViewById(R.id.tvCard);
        tvCard.setText(content);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                break;
        }
        return true;
    }
}
