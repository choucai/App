package com.dream.view.EgWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.dream.app.R;
import com.dream.util.UtilWin;

/**
 * Created by William Lee on 2015/8/28.
 * <p/>
 * 图像混合模式
 * <p/>
 * 自定义控件其实很简单1/6
 * http://blog.csdn.net/aigestudio/article/details/41316141
 */
public class CvPorterDuffView extends View {
    /*
         * PorterDuff模式常量
         * 可以在此更改不同的模式测试
         */

    /**
     * PorterDuff.Mode.ADD
     * 计算方式：Saturate(S + D)；Chinese：饱和相加
     * <p/>
     * PorterDuff.Mode.CLEAR
     * 计算方式：[0, 0]；Chinese：清除--清除图像
     * <p/>
     * PorterDuff.Mode.DARKEN
     * 计算方式：[Sa + Da - Sa*Da, Sc*(1 - Da) + Dc*(1 - Sa) + min(Sc, Dc)]；Chinese：变暗
     * 两个图像混合，较深的颜色总是会覆盖较浅的颜色，如果两者深浅相同则混合
     * <p/>
     * PorterDuff.Mode.DST
     * 计算方式：[Da, Dc]；Chinese：只绘制目标图像
     * <p/>
     * PorterDuff.Mode.DST_ATOP
     * 计算方式：[Sa, Sa * Dc + Sc * (1 - Da)]；Chinese：在源图像和目标图像相交的地方绘制目标图像而在不相交的地方绘制源图像
     * <p/>
     * PorterDuff.Mode.DST_IN
     * 计算方式：[Sa * Da, Sa * Dc]；Chinese：只在源图像和目标图像相交的地方绘制目标图像
     * 最常见的应用就是蒙板绘制，利用源图作为蒙板“抠出”目标图上的图像
     * <p/>
     * PorterDuff.Mode.DST_OUT
     * 计算方式：[Da * (1 - Sa), Dc * (1 - Sa)]；Chinese：只在源图像和目标图像不相交的地方绘制目标图像
     * <p/>
     * PorterDuff.Mode.DST_OVER
     * 计算方式：[Sa + (1 - Sa)*Da, Rc = Dc + (1 - Da)*Sc]；Chinese：在源图像的上方绘制目标图像
     * <p/>
     * PorterDuff.Mode.LIGHTEN
     * 计算方式：[Sa + Da - Sa*Da, Sc*(1 - Da) + Dc*(1 - Sa) + max(Sc, Dc)]；Chinese：变亮
     * <p/>
     * PorterDuff.Mode.MULTIPLY
     * 计算方式：[Sa * Da, Sc * Dc]；Chinese：正片叠底
     * 该模式通俗的计算方式很简单，
     * 源图像素颜色值乘以目标图像素颜色值除以255即得混合后图像像素的颜色值，
     * 该模式在设计领域应用广泛，
     * 因为其特性黑色与任何颜色混合都会得黑色，在手绘的上色、三维动画的UV贴图绘制都有应用
     * <p/>
     * PorterDuff.Mode.OVERLAY
     * 计算方式：未给出；Chinese：叠加
     * 它会将源色与目标色混合产生一种中间色，
     * 这种中间色生成的规律也很简单，如果源色比目标色暗，
     * 那么让目标色的颜色倍增否则颜色递减。
     * <p/>
     * PorterDuff.Mode.SCREEN
     * 计算方式：[Sa + Da - Sa * Da, Sc + Dc - Sc * Dc]；Chinese：滤色
     * 滤色产生的效果我认为是Android提供的几个色彩混合模式中最好的，它可以让图像焦媃幻化，有一种色调均和的感觉：
     * <p/>
     * PorterDuff.Mode.SRC
     * 计算方式：[Sa, Sc]；Chinese：显示源图
     * <p/>
     * PorterDuff.Mode.SRC_ATOP
     * 计算方式：[Da, Sc * Da + (1 - Sa) * Dc]；Chinese：在源图像和目标图像相交的地方绘制源图像，在不相交的地方绘制目标图像
     * <p/>
     * PorterDuff.Mode.SRC_IN
     * 计算方式：[Sa * Da, Sc * Da]；Chinese：只在源图像和目标图像相交的地方绘制源图像
     * <p/>
     * PorterDuff.Mode.SRC_OUT
     * 计算方式：[Sa * (1 - Da), Sc * (1 - Da)]；Chinese：只在源图像和目标图像不相交的地方绘制源图像
     * <p/>
     * PorterDuff.Mode.SRC_OVER
     * 计算方式：[Sa + (1 - Sa)*Da, Rc = Sc + (1 - Sa)*Dc]；Chinese：在目标图像的顶部绘制源图像
     * <p/>
     * PorterDuff.Mode.XOR
     * 计算方式：[Sa + Da - 2 * Sa * Da, Sc * (1 - Da) + (1 - Sa) * Dc]；Chinese
     * 在源图像和目标图像重叠之外的任何地方绘制他们，而在不重叠的地方不绘制任何内容
     *
     *
     */
    private static final PorterDuff.Mode MODE = PorterDuff.Mode.SCREEN;

    private static final int RECT_SIZE_SMALL = 400;// 左右上方示例渐变正方形的尺寸大小
    private static final int RECT_SIZE_BIG = 800;// 中间测试渐变正方形的尺寸大小

    private Paint mPaint;// 画笔

    private PorterDuffBO porterDuffBO;// PorterDuffView类的业务对象
    private PorterDuffXfermode porterDuffXfermode;// 图形混合模式

    private int screenW, screenH;// 屏幕尺寸
    private int s_l, s_t;// 左上方正方形的原点坐标
    private int d_l, d_t;// 右上方正方形的原点坐标
    private int rectX, rectY;// 中间正方形的原点坐标

    public CvPorterDuffView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // 实例化画笔并设置抗锯齿
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        // 实例化业务对象
        porterDuffBO = new PorterDuffBO();

        // 实例化混合模式
        porterDuffXfermode = new PorterDuffXfermode(MODE);

        // 计算坐标
        calu(context);
    }

    /**
     * 计算坐标
     *
     * @param context 上下文环境引用
     */
    private void calu(Context context) {

        // 获取屏幕尺寸
        screenW = UtilWin.getScreenWidth(context);
        screenH = UtilWin.getScreenHeight(context);

        // 计算左上方正方形原点坐标
        s_l = 0;
        s_t = 0;

        // 计算右上方正方形原点坐标
        d_l = screenW - RECT_SIZE_SMALL;
        d_t = 0;

        // 计算中间方正方形原点坐标
        rectX = screenW / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (screenH - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 设置画布颜色为黑色以便我们更好地观察
        canvas.drawColor(Color.BLACK);

        // 设置业务对象尺寸值计算生成左右上方的渐变方形
        porterDuffBO.setSize(RECT_SIZE_SMALL);

		/*
         * 画出左右上方两个正方形
		 * 其中左边的的为src右边的为dis
		 */
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), s_l, s_t, mPaint);
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), d_l, d_t, mPaint);

		/*
         * 将绘制操作保存到新的图层（更官方的说法应该是离屏缓存）我们将在1/3中学习到Canvas的全部用法这里就先follow me
		 */
        int sc = canvas.saveLayer(0, 0, screenW, screenH, null, Canvas.ALL_SAVE_FLAG);

        // 重新设置业务对象尺寸值计算生成中间的渐变方形
        porterDuffBO.setSize(RECT_SIZE_BIG);

        // 先绘制dis目标图
        canvas.drawBitmap(porterDuffBO.initDisBitmap(), rectX, rectY, mPaint);

        // 设置混合模式
        mPaint.setXfermode(porterDuffXfermode);

        // 再绘制src源图
        canvas.drawBitmap(porterDuffBO.initSrcBitmap(), rectX, rectY, mPaint);

        // 还原混合模式
        mPaint.setXfermode(null);

        // 还原画布
        canvas.restoreToCount(sc);
    }

}
