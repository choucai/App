package com.dream.widget;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;

import com.dream.app.R;
import com.dream.base.BaseActivity;

/**
 * NavigationView‘s Demo
 */
public class NavigationViewActivity extends BaseActivity {

    NavigationView navigationView1,navigationView2;

    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        initNavigationView();
    }


    private void initNavigationView() {
        navigationView1 = (NavigationView) findViewById(R.id.navigationView1);
        navigationView2 = (NavigationView) findViewById(R.id.navigationView2);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //设置侧滑菜单选择监听事件
        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                //关闭抽屉侧滑菜单
                drawerLayout.closeDrawers();
                return true;
            }
        });
        navigationView2.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                //关闭抽屉侧滑菜单
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {  //打开抽屉侧滑菜单
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

}
