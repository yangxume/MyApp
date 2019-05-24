package com.xy.my_retrofit_rxjava2_task.utils;

import android.util.Log;

public class LogUtils {

    /**
     * 日志输出时的TAG
     */

    public static String mTag = "TAG";

    protected static boolean IS_LOG = true;

    public static boolean setLogIsOpen(boolean islog) {
        IS_LOG = islog;
        return IS_LOG;
    }

    public static boolean isLogOpen() {
        return IS_LOG;
    }

    /**
     * 以级别为 d 的形式输出LOG
     */

    public static void v(String msg) {

        if (IS_LOG) {

            if (msg == null) {
                msg = "";
            }

            Log.v(mTag, msg);
        }

    }

    /**
     * 以级别为 d 的形式输出LOG
     */

    public static void d(String msg) {

        if (IS_LOG) {

            if (msg == null) {
                msg = "";
            }
            Log.d(mTag, msg);

        }

    }

    /**
     * 以级别为 d 的形式输出LOG
     */

    public static void d(String tag, String msg) {

        if (IS_LOG) {
            if (tag == null) {
                tag = "";
            }

            if (msg == null) {
                msg = "";
            }
            Log.d(tag, msg);

        }

    }


    /**
     * 以级别为 i 的形式输出LOG
     */

    public static void i(String msg) {

        if (IS_LOG) {

            if (msg == null) {
                msg = "";
            }
            Log.i(mTag, msg);

        }

    }

    /**
     * 以级别为 w 的形式输出LOG
     */

    public static void w(String msg) {

        if (IS_LOG) {
            if (msg == null) {
                msg = "";
            }
            Log.w(mTag, msg);

        }

    }

    /**
     * 以级别为 e 的形式输出LOG
     */

    public static void e(String msg) {

        if (IS_LOG) {
            if (msg == null) {
                msg = "";
            }
            Log.e(mTag, msg);

        }

    }

    public static void e(String tag, String msg) {

        if (IS_LOG) {
            if (tag == null) {
                tag = "";
            }

            if (msg == null) {
                msg = "";
            }
            Log.e(tag, msg);
        }
    }


}

