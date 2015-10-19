package com.dream.widget;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.dream.app.R;
import com.dream.base.BaseActivity;

/**
 * http://blog.csdn.net/feiduclear_up/article/details/46457433
 */
public class ToolbarActivity extends BaseActivity implements Toolbar.OnMenuItemClickListener {

    Toolbar tlBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);

        tlBar = (Toolbar) findViewById(R.id.tb_bar);
        setSupportActionBar(tlBar);

        // Toolbar可以设置 Title（主标题），Subtitle（副标题），Logo（logo图标）NavigationIcon（导航按钮）
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        tlBar.setTitle("主标题");
        tlBar.setSubtitle("子标题");

        tlBar.setLogo(android.R.drawable.ic_lock_lock);
        tlBar.setNavigationIcon(android.R.drawable.ic_delete);

        tlBar.setOnMenuItemClickListener(this);
    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(this, "查找按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(this, "分享按钮", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
