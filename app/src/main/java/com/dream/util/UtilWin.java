package com.dream.util;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * 窗口工具类.
 *
 * @author 李君波
 * @version 1.0 2014-10-21
 */
public class UtilWin {

    /**
     * 工具类禁止实例化
     */
    private UtilWin() {

    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context
     * @param dpValue
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 返回屏幕宽度
     *
     * @param context
     * @return int
     * @Title: getScreenWidth
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point w = new Point();
        wm.getDefaultDisplay().getSize(w);
        return w.x;
    }

    /**
     * 返回屏幕高度
     *
     * @param context
     * @return int
     * @Title: getScreenHeight
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point h = new Point();
        wm.getDefaultDisplay().getSize(h);
        return h.y;
    }

//    /**
//     * 返回状态栏的高度
//     *
//     * @param context
//     * @return int
//     * @Title: getScreenHeight
//     */
//    public static int getStatusBarHeight(Context context) {
//        Rect frame = new Rect();
//        ((Activity)context).getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
//        int statusBarHeight = frame.top; //状态栏的高度
//        return statusBarHeight;
//    }
//
//    /**
//     * 返回标题栏的高度
//     *
//     * @param context
//     * @return int
//     * @Title: getScreenHeight
//     */
//    public static int getTitleBarHeight(Context context) {
//
//        Rect frame = new Rect();
//        ((Activity)context).getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
//        int statusBarHeight = frame.top; //状态栏的高度
//
//        int contentTop = ((Activity)context).getWindow().findViewById(Window.ID_ANDROID_CONTENT).getTop();
//        int titleBarHeight = contentTop - statusBarHeight;
//        return titleBarHeight;
//    }
//
//    /**
//     * 返回内容区的高度
//     *
//     * @param context
//     * @return int
//     * @Title: getScreenHeight
//     */
//    public static int getContentAreaHeight(Context context) {
//        Rect frame = new Rect();
//        ((Activity)context).getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
//        int statusBarHeight = frame.top; //状态栏的高度
//        return getScreenHeight(context) - statusBarHeight;
//    }

}
