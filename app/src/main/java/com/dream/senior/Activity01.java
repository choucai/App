package com.dream.senior;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.dream.app.R;
import com.dream.base.BaseActivity;

/**
 * http://blog.csdn.net/yanbober/article/details/50276769
 */
public class Activity01 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_adapter);

        Typeface iconfont = Typeface.createFromAsset(getAssets(), "iconfont.ttf");
        TextView tv = (TextView) findViewById(R.id.tv_icon_font);
        tv.setTypeface(iconfont);
    }


}
