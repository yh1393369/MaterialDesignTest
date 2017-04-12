package com.rookie.www.materialdesigntest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {


    private Toolbar tbMain;
    private DrawerLayout dlMain;
    private NavigationView nvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tbMain = (Toolbar) findViewById(R.id.tbMain);
        setSupportActionBar(tbMain);
        dlMain = (DrawerLayout) findViewById(R.id.dlMain);
        nvMain = (NavigationView) findViewById(R.id.nvMain);
        View headerView = nvMain.inflateHeaderView(R.layout.nav_header_main);
        CircleImageView civNavHeaderMain = (CircleImageView) headerView.findViewById(R.id.civNavHeaderMain);
        civNavHeaderMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "显示图片", Toast.LENGTH_SHORT).show();
                dlMain.closeDrawers();
            }
        });
        nvMain.setItemIconTintList(null);
        nvMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this, "选择了"+item.getTitle(), Toast.LENGTH_SHORT).show();
                dlMain.closeDrawers();
                return false;
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(android.R.drawable.ic_menu_more);
        }
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
            case android.R.id.home :
                dlMain.openDrawer(GravityCompat.START, true);
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
