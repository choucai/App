package com.dream.view.EgWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
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
public class CvImageColorMatrixColorFilter extends View {

    private Context mContext;// 上下文环境引用

    private Paint mPaint;

    private Bitmap bitmap;// 位图

    private int x,y;// 位图绘制时左上角的起点坐标

    /**
     * 矩阵不同的位置表示的RGBA值
     * 其范围在0.0F至2.0F之间
     * 1为保持原图的RGB值
     * 每一行的第五列数字表示偏移值
     */
    ColorMatrix colorMatrixOrigin = new ColorMatrix(new float[]{
            1, 0, 0, 0, 0,
            0, 1, 0, 0, 0,
            0, 0, 1, 0, 0,
            0, 0, 0, 1, 0,
    });

    ColorMatrix colorMatrix1 = new ColorMatrix(new float[]{
            0.5F, 0, 0, 0, 0,
            0, 0.5F, 0, 0, 0,
            0, 0, 0.5F, 0, 0,
            0, 0, 0, 1, 0,
    });

    ColorMatrix colorMatrix2 = new ColorMatrix(new float[]{
            0.33F, 0.59F, 0.11F, 0, 0,
            0.33F, 0.59F, 0.11F, 0, 0,
            0.33F, 0.59F, 0.11F, 0, 0,
            0, 0, 0, 1, 0,
    });

    ColorMatrix colorMatrix3 = new ColorMatrix(new float[]{
            -1, 0, 0, 1, 1,
            0, -1, 0, 1, 1,
            0, 0, -1, 1, 1,
            0, 0, 0, 1, 0,
    });

    ColorMatrix colorMatrix4 = new ColorMatrix(new float[]{
            0, 0, 1, 0, 0,
            0, 1, 0, 0, 0,
            1, 0, 0, 0, 0,
            0, 0, 0, 1, 0,
    });

    ColorMatrix colorMatrix5 = new ColorMatrix(new float[]{
            0.393F, 0.769F, 0.189F, 0, 0,
            0.349F, 0.686F, 0.168F, 0, 0,
            0.272F, 0.534F, 0.131F, 0, 0,
            0, 0, 0, 1, 0,
    });

    ColorMatrix colorMatrix6 = new ColorMatrix(new float[]{
            1.5F, 1.5F, 1.5F, 0, -1,
            1.5F, 1.5F, 1.5F, 0, -1,
            1.5F, 1.5F, 1.5F, 0, -1,
            0, 0, 0, 1, 0,
    });

    public CvImageColorMatrixColorFilter(Context context) {
        super(context);
        mContext = context;
        initPaint();
    }

    public CvImageColorMatrixColorFilter(Context context, AttributeSet attrs) {
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
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix6));
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
        x = UtilWin.getScreenWidth(mContext)/2 - bitmap.getWidth() / 2;
        y = UtilWin.getScreenHeight(mContext)/2 - bitmap.getHeight() / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制位图
        canvas.drawBitmap(bitmap, x, y, mPaint);
    }

}
