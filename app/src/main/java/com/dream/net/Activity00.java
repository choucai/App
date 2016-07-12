package com.dream.net;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.dream.app.R;
import com.dream.base.BaseActivity;

/**
 * Uri详解之——Uri结构与代码提取.
 *
 * http://blog.csdn.net/harvic880925/article/details/44679239
 * http://www.cnblogs.com/fsjohnhuang/p/4280369.html
 */
public class Activity00 extends BaseActivity {

    String url = "http://www.java2s.com:8080/yourpath/fileName.htm?stove=10&path=32&id=4#harvic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_00);

        Uri uri = Uri.parse(url);
        ((TextView)findViewById(R.id.tv_all)).setText(url);

        String scheme = uri.getScheme();
        ((TextView)findViewById(R.id.tv_scheme)).setText(scheme);

        String host = uri.getHost();
        ((TextView)findViewById(R.id.tv_host)).setText(host);

        String port = String.valueOf(uri.getPort());
        ((TextView)findViewById(R.id.tv_port)).setText(port);

        String path = uri.getPath();
        ((TextView)findViewById(R.id.tv_path)).setText(path);

        String query = uri.getQuery();
        ((TextView)findViewById(R.id.tv_query)).setText(query);

        String fragment = uri.getFragment();
        ((TextView)findViewById(R.id.tv_fragment)).setText(fragment);

        String allUri = uri.toString();
        ((TextView)findViewById(R.id.tv_all_uri)).setText(allUri);

    }


}
