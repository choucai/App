package com.dream.util;

import android.util.Log;

/**
 * 封装Log类,便于统一输出日志,等版本上线之后可关闭日志输出.
 * 
 * @author 李君波
 * @version 1.0 2014-10-21
 */ 
public class UtilLog {

	/** 全局TAG */
	private static final String TAG = "Dream";

	/** 输出verbose级别之上的日志 */
	public static final int VERBOSE = 1;

	/** 输出debug级别之上的日志 */
	public static final int DEBUG = 2;

	/** 输出info级别之上的日志 */
	public static final int INFO = 3;

	/** 输出warn级别之上的日志 */
	public static final int WARN = 4;

	/** 输出error级别之上的日志 */
	public static final int ERROR = 5;
	
	/** 关闭日志输出 */
	@SuppressWarnings("unused")
	public static final int NOTHING = 6;

	public static final int LEVEL = VERBOSE;
	
	private UtilLog() {

	}
	
	public static void v(String tag,String msg){
		if(LEVEL <= VERBOSE ){
			Log.v(TAG, tag + "--" + msg);
		}
	}

	public static void d(String tag,String msg){
		if(LEVEL <= DEBUG ){
			Log.d(TAG, tag + "--" + msg);
		}
	}
	
	public static void i(String tag,String msg){
		if(LEVEL <= INFO ){
			Log.i(TAG, tag + "--" + msg);
		}
	}
	
	public static void w(String tag,String msg){
		if(LEVEL <= WARN ){
			Log.w(TAG, tag + "--" + msg);
		}
	}
	
	public static void e(String tag,String msg){
		if(LEVEL <= ERROR ){
			Log.e(TAG, tag + "--" + msg);
		}
	}
	
}
