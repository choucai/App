package com.dream.view.EgWidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.dream.util.UtilWin;

/**
 * Created by William Lee on 2015/8/28.
 *
 * 自定义控件其实很简单1/6
 * http://blog.csdn.net/aigestudio/article/details/41316141
 *
 */
public class CvCircleMatrix extends View {

    private Context mContext;// 上下文环境引用

    private Paint mPaint;

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

    public CvCircleMatrix(Context context) {
        super(context);
        mContext = context;
        initPaint();
    }

    public CvCircleMatrix(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {

        /** 实例化画笔并打开抗锯齿 */
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

		/**
		 * 设置画笔样式为描边，圆环嘛……当然不能填充不然就么意思了
		 *
		 * 画笔样式分三种：
		 * 1.Paint.Style.STROKE：描边
		 * 2.Paint.Style.FILL_AND_STROKE：描边并填充
		 * 3.Paint.Style.FILL：填充
		 */
        mPaint.setStyle(Paint.Style.FILL);

        /** 设置画笔颜色为浅灰色 */
        mPaint.setColor(Color.argb(255, 255, 128, 103));

        /** 设置色彩矩阵颜色过滤器 */
        mPaint.setColorFilter(new ColorMatrixColorFilter(colorMatrix1));


        /**
         * 设置描边的粗细，单位：像素px
         * 注意：当setStrokeWidth(0)的时候描边宽度并不为0而是只占一个像素
         */
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制圆环
        int x = UtilWin.getScreenWidth(mContext)/2;
        int y = UtilWin.getScreenHeight(mContext)/2;
        canvas.drawCircle(x,y,200,mPaint);
    }

}
