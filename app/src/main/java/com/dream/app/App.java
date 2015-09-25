package com.dream.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by William Lee on 2015/9/12.
 */
public class App extends Application{

    /** 全局Context */
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    /**
     * 获取全局Context
     *
     * @return mContext
     */
    public static Context getContext() {
        return mContext;
    }


}
