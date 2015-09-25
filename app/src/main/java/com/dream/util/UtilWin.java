package com.dream.util;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

import com.dream.app.App;

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
     * @param dpValue
     */
    public static int dip2px(float dpValue) {
        final float scale = App.getContext().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        final float scale = App.getContext().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 返回屏幕宽度
     *
     * @return int
     * @Title: getScreenWidth
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) App.getContext().getSystemService(Context.WINDOW_SERVICE);
        Point w = new Point();
        wm.getDefaultDisplay().getSize(w);
        return w.x;
    }

    /**
     * 返回屏幕高度
     *
     * @return int
     * @Title: getScreenHeight
     */
    public static int getScreenHeight() {
        WindowManager wm = (WindowManager) App.getContext().getSystemService(Context.WINDOW_SERVICE);
        Point h = new Point();
        wm.getDefaultDisplay().getSize(h);
        return h.y;
    }

}
