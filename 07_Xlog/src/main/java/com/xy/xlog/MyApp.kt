package com.xy.xlog

import android.app.Application
import android.os.Environment
import com.tencent.mars.xlog.Xlog
import kotlin.math.log

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initXlogEnv()
    }

    private fun initXlogEnv() {
        System.loadLibrary("stlport_shared");
        System.loadLibrary("marsxlog");
        val sdcard: String = Environment.getExternalStorageDirectory().getAbsolutePath();
        val logPath: String = sdcard + "/xlogdemo/log";
//        var cachePath: String = this.getFilesDir()+"/xlogdemo/xlog"
        val cachePath = logPath
        if (BuildConfig.DEBUG) {
            Xlog.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, cachePath, logPath, "", "");
            Xlog.setConsoleLogOpen(true);

        } else {
            Xlog.appenderOpen(Xlog.LEVEL_INFO, Xlog.AppednerModeAsync, cachePath, logPath, "MarsSample", "");
            Xlog.setConsoleLogOpen(false);
        }

    }

}

