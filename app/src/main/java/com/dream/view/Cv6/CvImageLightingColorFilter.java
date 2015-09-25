package com.dream.view.Cv6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
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
public class CvImageLightingColorFilter extends View {

    private Context mContext;// 上下文环境引用

    private Paint mPaint;

    private Bitmap bitmap;// 位图

    private int x,y;// 位图绘制时左上角的起点坐标

    public CvImageLightingColorFilter(Context context) {
        super(context);
        mContext = context;
        initPaint();
    }

    public CvImageLightingColorFilter(Context context, AttributeSet attrs) {
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
         *
         * mul全称是colorMultiply意为色彩倍增
         * 而add全称是colorAdd意为色彩添加
         * 这两个值都是16进制的色彩值0xAARRGGBB
         *
         * LightingColorFilter(0xFFFFFFFF, 0x00000000)的时候原图是不会有任何改变的
         * 如果我们想增加红色的值，那么LightingColorFilter(0xFFFFFFFF, 0x00XX0000)就好
         * 其中XX取值为00至FF
         */
        mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
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
