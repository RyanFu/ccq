/*
 * 文件名：ULog.java
 * 版权：(C)版权所有2013-2013宇龄信息科技(无锡)有限公司
 * 描述：日志工具类,提供日志开关,级别,和日志定位功能
 * 修改人：ze.chen
 * 修改时间：2013-6-4 下午2:04:55
 */
package com.coldmn3.nga.utils;

import com.coldmn3.nga.app.NgaApplication;

import android.util.Log;

/**
 * 日志工具类,提供日志开关,级别,和日志定位功能<br>
 * 日志工具类,提供日志开关,级别,和日志定位功能;日志定位的核心思想是通过异常堆栈追溯日志来源
 * 
 * @author ze.chen
 * @version 1.0
 * @date 2013-6-4 下午2:04:55
 */
public class ULog {
	public static boolean DEBUG = true;

	/**
	 * 基本日志接口
	 * 
	 * @param tag
	 * @param msg
	 * @param level
	 */
	public static void log(String tag, String msg, int level) {
		if (isDebug()) {
			String msgs = msg;
			String tags = tag;
			Exception e = new Exception();
			StackTraceElement[] els = e.getStackTrace();

			String logDetails = NgaApplication.PACKAGENAME;
			for (int i = 0, l = els.length; i < l; i++) {
				if (els[i].getClassName().startsWith(NgaApplication.PACKAGENAME)
						&& !els[i].getClassName().equals(ULog.class.getName())) {
					logDetails = els[i].getFileName() + "->" + els[i].getMethodName() + ":" + els[i].getLineNumber()
							+ " ";
					msgs = logDetails + msgs;
					if ("".equals(tags)) {
						tags = els[i].getFileName().substring(0, els[i].getFileName().indexOf("."));
					}
					break;
				}
			}
			switch (level) {
			case Log.DEBUG:
				Log.d(tags, msgs);
				break;
			case Log.INFO:
				Log.i(tags, msgs);
				break;
			case Log.WARN:
				Log.w(tags, msgs);
				break;
			case Log.ERROR:
				Log.e(tags, msgs);
				break;
			default:
				Log.d(tag, msgs);
				break;
			}
		}
	}

	/**
	 * Simple log
	 * 
	 * @param tag
	 * @param msg
	 */
	public static void log(String tag, String msg) {
		log(tag, msg, Log.WARN);
	}

	public static void log(String msg) {
		log("", msg);
	}

	public static void info(String msg) {
		log("", msg, Log.INFO);
	}

	public static void error(String msg) {
		log("", msg, Log.ERROR);
	}

	public static void debug(String msg) {
		log("", msg, Log.DEBUG);
	}

	public static void error(String tag, String msg) {
		log(tag, msg, Log.ERROR);
	}

	public static void d(String tag, String msg, Throwable tr) {
		if (isDebug()) {
			Log.d(tag, msg, tr);
		}
	}

	public static void v(String tag, String msg, Throwable tr) {
		if (isDebug()) {
			Log.v(tag, msg, tr);
		}
	}

	public static void i(String tag, String msg, Throwable tr) {
		if (isDebug()) {
			Log.i(tag, msg, tr);
		}
	}

	public static void w(String tag, String msg, Throwable tr) {
		if (isDebug()) {
			Log.w(tag, msg, tr);
		}
	}

	public static void e(String tag, String msg, Throwable tr) {
		if (isDebug()) {
			Log.e(tag, msg, tr);
		}
	}

	private static boolean inited = false;
	
	private static boolean isDebug() {
		if (inited)
			return DEBUG;
		DEBUG = true;
		inited = true;
		return DEBUG;
	}
}
