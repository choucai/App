package com.dream.plugin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.dream.app.R;
import com.dream.base.BaseActivity;

/**
 * 插件研究.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-22 11:26:02s.
 * @phone 152-5320-8570
 */
public class PluginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_plugin);
        setTitle("Plugin Demo");

        Toolbar toolbar = (Toolbar) findViewById(R.id.tl_plugin_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_36dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btn_start_plugin1) {
            Intent intent = new Intent(this, ProxyActivity.class);
            intent.putExtra(ProxyActivity.EXTRA_DEX_PATH, "/mnt/sdcard/dlh/plugin.apk");
            startActivity(intent);
        }

        if (v.getId() == R.id.btn_start_plugin2) {

        }
    }


}
