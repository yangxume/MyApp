package com.okay.myapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.okay.myapp.bean.MyBinder;
import com.okay.myapp.utils.LogUtils;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/15 10:59
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MyService extends Service {

    /**
     * 1、新建一个继承自Service的类MyService，然后在AndroidManifest.xml里注册这个Service
     */
    private static final String TAG = MyService.class.getSimpleName();
    private MyBinder myBinder = new MyBinder(this);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBinder;
    }

    public void serviceMethod(String str) {
        LogUtils.d(TAG, "receive msg from activity->" + str);
    }
}
