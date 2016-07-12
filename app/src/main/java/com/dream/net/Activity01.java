package com.dream.net;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dream.app.R;

/**
 * Android序列化：Serializable和Parcelable详解.
 *
 * http://blog.csdn.net/k845824379/article/details/49617959
 */
public class Activity01 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_01);
    }
}
