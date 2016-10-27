package com.dream.net;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.dream.app.R;
import com.dream.base.BaseActivity;

/**
 * Deep Links.
 * <p>
 * http://chuansong.me/n/355263951030
 */
public class Activity02 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_links);

        WebView wvDeepLinks = (WebView) findViewById(R.id.wv_deep_links);
        wvDeepLinks.loadUrl("file:///android_asset/deeplinks.html");

        Intent intent = getIntent();
        if (intent != null) {
            Uri uri = intent.getData();
            if(null == uri) return;
            String host = uri.getHost();

            String toast = null;
            switch (host) {
                case "start":
                    toast = "start music";
                    break;
                case "play":
                    toast = "play music";
                    break;
                case "pause":
                    toast = "pause music";
                    break;
                case "stop":
                    toast = "stop music";
                    break;
            }
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
        }
    }

}
