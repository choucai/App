package com.dream.test.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * TODO.
 *
 * @author 李君波
 * @version v1.0.0
 * @created 2016-05-21 上午9:53.
 * @phone 152-5320-8570
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "Client-BaseActivity";
    public static final String FROM = "extra.from";

    public static final int FROM_EXTERNAL = 0;
    public static final int FROM_INTERNAL = 1;

    public static final String EXTRA_DEX_PATH = "extra.dex.path";
    public static final String EXTRA_CLASS = "extra.class";

    /**
     * 此处是添加到代理Activity中去的.
     */
    public static final String PROXY_VIEW_ACTION = "com.dream.test.VIEW";
    public static final String DEX_PATH = "/mnt/sdcard/dlh/plugin.apk";

    protected Activity mProxyActivity;
    protected int mFrom = FROM_INTERNAL;


    public void setProxy(Activity proxyActivity) {
        Log.d(TAG, "setProxy: proxyActivity= " + proxyActivity);
        mProxyActivity = proxyActivity;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mFrom = savedInstanceState.getInt(FROM, FROM_INTERNAL);
        }
        if (mFrom == FROM_INTERNAL) {
            super.onCreate(savedInstanceState);
            mProxyActivity = this;
        }
        Log.d(TAG, "onCreate: from= " + mFrom);
    }


    protected void startActivityByProxy(String className) {
        if (mProxyActivity == this) {
            Intent intent = new Intent();
            intent.setClassName(this, className);
            this.startActivity(intent);
        } else {
            Intent intent = new Intent(PROXY_VIEW_ACTION);
            intent.putExtra(EXTRA_DEX_PATH, DEX_PATH);
            intent.putExtra(EXTRA_CLASS, className);
            mProxyActivity.startActivity(intent);
        }
    }


    @Override
    public void setContentView(View view) {
        if (mProxyActivity == this) {
            super.setContentView(view);
        } else {
            mProxyActivity.setContentView(view);
        }
    }


    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        if (mProxyActivity == this) {
            super.setContentView(view, params);
        } else {
            mProxyActivity.setContentView(view, params);
        }
    }


    @Deprecated
    @Override
    public void setContentView(int layoutResID) {
        if (mProxyActivity == this) {
            super.setContentView(layoutResID);
        } else {
            mProxyActivity.setContentView(layoutResID);
        }
    }


    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        if (mProxyActivity == this) {
            super.addContentView(view, params);
        } else {
            mProxyActivity.addContentView(view, params);
        }
    }

}
