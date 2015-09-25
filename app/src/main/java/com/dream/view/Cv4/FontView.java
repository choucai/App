package com.dream.view.Cv4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.dream.util.UtilLog;

/**
 *
 * 自定义控件其实很简单1/4
 * http://blog.csdn.net/aigestudio/article/details/41447349
 */
public class FontView extends View {

    private static final String TEXT = "ap爱哥ξτβбпшㄎㄊěǔぬも┰┠№＠↓";

    private Paint mPaint;// 画笔

    private Paint.FontMetrics mFontMetrics;

    public FontView(Context context) {
        this(context, null);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(60);
        mPaint.setTypeface(Typeface.SERIF);
        mPaint.setColor(Color.BLACK);

        mFontMetrics = mPaint.getFontMetrics();

        UtilLog.d("Aige", "ascent：" + mFontMetrics.ascent);
        UtilLog.d("Aige", "top：" + mFontMetrics.top);

        UtilLog.d("Aige", "leading：" + mFontMetrics.leading);

        UtilLog.d("Aige", "descent：" + mFontMetrics.descent);
        UtilLog.d("Aige", "bottom：" + mFontMetrics.bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawText(TEXT, 0, 0, mPaint);
        canvas.drawText(TEXT, 0, Math.abs(mFontMetrics.top), mPaint);
    }
}
