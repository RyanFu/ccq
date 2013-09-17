/*
    CCQ Android Client
    Copyright (c) 2013 Wu Hai <coldmn3@gmail.com>
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package com.coldmn3.young.utils;

import android.util.Log;
import com.coldmn3.young.android.YBaseApplication;
import com.coldmn3.young.file.PropertyManager;

/**
 * 日志工具类,提供日志开关,级别,和日志定位功能<br>
 * 日志工具类,提供日志开关,级别,和日志定位功能;日志定位的核心思想是通过异常堆栈追溯日志来源
 *
 * @version 1.0
 * @author： session
 * @date：2013-9-4 下午2:37
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

            for (int i = 0, l = els.length; i < l; i++) {
                if (els[i].getClassName().startsWith(YBaseApplication.PACKAGE_NAME)
                        && !els[i].getClassName().equals(ULog.class.getName())) {
                    String logDetails = els[i].getFileName() + "->" + els[i].getMethodName() + ":" + els[i].getLineNumber()
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
        DEBUG = Boolean.parseBoolean(PropertyManager.get("log", "true"));
        inited = true;
        return DEBUG;
    }
}
