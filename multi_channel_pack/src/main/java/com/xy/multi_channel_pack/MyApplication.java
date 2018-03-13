package com.xy.multi_channel_pack;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/28 14:21
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getChannel(Context ctx) {

        try {

            PackageManager pm = ctx.getPackageManager();
            ApplicationInfo appInfo = pm.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);

            return appInfo.metaData.getString("channel");

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";


    }
}
