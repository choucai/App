package com.dream.view.Cv6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;

import com.dream.app.R;
import com.dream.util.UtilWin;

/**
 * Created by William Lee on 2015/8/28.
 *
 * 自定义控件其实很简单1/6
 * http://blog.csdn.net/aigestudio/article/details/41316141
 *
 */
public class CvImagePorterDuffColorFilter extends View {

    private Context mContext;// 上下文环境引用

    private Paint mPaint;

    private Bitmap bitmap;// 位图

    private int x,y;// 位图绘制时左上角的起点坐标

    public CvImagePorterDuffColorFilter(Context context) {
        super(context);
        mContext = context;
        initPaint();
    }

    public CvImagePorterDuffColorFilter(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;

        initPaint();
        initRes(context);
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        /** 实例化画笔并打开抗锯齿 */
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        /**
         * 设置颜色过滤
         *构造方法也接受两个值
         * 一个是16进制表示的颜色值这个很好理解
         * 而另一个是PorterDuff内部类Mode中的一个常量值
         * 这个值表示混合模式。
         */
        mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
    }

    /**
     * 初始化资源
     */
    private void initRes(Context context) {
        // 获取位图
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.a);

        /*
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向上偏移位图一半的高度
         */
        // 绘制圆环
        x = UtilWin.getScreenWidth()/2 - bitmap.getWidth() / 2;
        y = UtilWin.getScreenHeight()/2 - bitmap.getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制位图
        canvas.drawBitmap(bitmap, x, y, mPaint);
    }

}
