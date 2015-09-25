package com.dream.view.Cv4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;


/**
 * 自定义控件其实很简单1/4
 * http://blog.csdn.net/aigestudio/article/details/41447349
 */
public class StaticLayoutView extends View {

    private static final String TEXT = "This is used by widgets to control text layout. You should not need to use this class directly unless you are implementing your own widget or custom display object, or would be tempted to call Canvas.drawText() directly.";
    private TextPaint mTextPaint;// 文本的画笔
    private StaticLayout mStaticLayout;// 文本布局

    public StaticLayoutView(Context context) {
        this(context, null);
    }

    public StaticLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 初始化画笔
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        // 实例化画笔
        mTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);

        mTextPaint.setTextSize(50);
        mTextPaint.setColor(Color.BLACK);

        mTextPaint.setUnderlineText(true);

        /**
         * Android中字体有四种样式：BOLD（加粗）,BOLD_ITALIC（加粗并倾斜）,ITALIC（倾斜）,NORMAL（正常）
         *
         * 而其为我们提供的字体有五种：DEFAULT,DEFAULT_BOLD,MONOSPACE,SANS_SERIF和SERIF
         */
//        mTextPaint.setTypeface(Typeface.SERIF);
//        mTextPaint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.BOLD_ITALIC));
        mTextPaint.setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mStaticLayout = new StaticLayout(TEXT, mTextPaint, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0F, 0.0F, false);
        mStaticLayout.draw(canvas);
        canvas.restore();
    }
}
