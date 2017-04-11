package com.rookie.www.materialdesigntest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar tbMain = (Toolbar) findViewById(R.id.tbMain);
        setSupportActionBar(tbMain);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        setMenuItemIconEnable(menu, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuItemAbout :
                Toast.makeText(this, "版本1.0", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuItemExit :
                finish();
                break;
        }
        return true;
    }

    private void setMenuItemIconEnable(Menu menu, boolean enable){
        try {
            Class menuBuilder = Class.forName("android.support.v7.view.menu.MenuBuilder");
            Method menuBuilderSetOptionalIconsVisible = menuBuilder.getMethod("setOptionalIconsVisible", boolean.class);
            menuBuilderSetOptionalIconsVisible.invoke(menu, enable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
