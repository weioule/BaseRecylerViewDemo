package com.e.multipleentries;

import android.text.TextUtils;
import android.util.Log;

public class LogUtil {

    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int ASSERT = 6;
    public static final int NOTHING = 7;
    public static int LEVEL = INFO;

    private static final String TAG = "LogUtil";

    public static void setLogLevel(int level) {
        LEVEL = level;
    }

    public static void v(String msg) {
        if (LEVEL <= VERBOSE && !TextUtils.isEmpty(msg)) {
            Log.v(TAG, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (LEVEL <= VERBOSE && !TextUtils.isEmpty(msg)) {
            Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        if (LEVEL <= DEBUG && !TextUtils.isEmpty(msg)) {
            Log.d(TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (LEVEL <= DEBUG && !TextUtils.isEmpty(msg)) {
            Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        if (LEVEL <= INFO && !TextUtils.isEmpty(msg)) {
            Log.i(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (LEVEL <= INFO && !TextUtils.isEmpty(msg)) {
            Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        if (LEVEL <= WARN && !TextUtils.isEmpty(msg)) {
            Log.w(TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (LEVEL <= WARN) {
            Log.w(tag, msg);
        }
    }

    public static void e(String msg) {
        if (LEVEL <= ERROR && !TextUtils.isEmpty(msg)) {
            Log.e(TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (LEVEL <= ERROR && !TextUtils.isEmpty(msg)) {
            Log.e(tag, msg);
        }
    }

    public static void a(String msg) {
        if (LEVEL <= ASSERT && !TextUtils.isEmpty(msg)) {
            Log.println(Log.ASSERT, TAG, msg);
        }
    }

    public static void a(String tag, String msg) {
        if (LEVEL <= ASSERT && !TextUtils.isEmpty(msg)) {
            Log.println(Log.ASSERT, tag, msg);
        }
    }
}