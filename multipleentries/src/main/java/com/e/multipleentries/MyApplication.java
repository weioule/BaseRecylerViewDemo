package com.e.multipleentries;

import android.app.Application;
import android.content.pm.ApplicationInfo;

import com.coder.zzq.smartshow.core.SmartShow;

/**
 * Created by weioule
 * on 2020/5/27
 */
public class MyApplication extends Application {

    public static MyApplication appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApplication.appContext = this;
        initLog();
        SmartShow.init(this);
    }

    private void initLog() {
        if (isInDebug()) {
            LogUtil.setLogLevel(LogUtil.VERBOSE);
        } else {
            LogUtil.setLogLevel(LogUtil.NOTHING);
        }
    }

    /**
     * 自动判断是否是debug状态
     * 注意事项：
     * 就是自己 App Module 中不能主动设置 android:debuggable，否则无论 Debug 还是 Release 版会始终是设置的值
     * 当然本身就没有自动设置的必要
     */
    public static boolean isInDebug() {
        try {
            ApplicationInfo info = appContext.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;

        } catch (Exception e) {
            return false;
        }
    }
}
