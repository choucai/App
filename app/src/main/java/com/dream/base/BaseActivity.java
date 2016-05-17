package com.dream.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * 所有Activity的基类
 * Created by William Lee on 2015/8/28.
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected String TAG;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLog();
    }

    /**
     * 用于确定当前界面是属于哪个活动(Activity), 让新加入开发的人快速锁定所在的界面,不得擅自移除.
     */
    private void initLog() {
        TAG = getClass().getSimpleName();
        Log.e(TAG, "包名---" + getClass().getPackage().getName());
        Log.e(TAG, "类名---" + getClass().getSimpleName());
    }


}
