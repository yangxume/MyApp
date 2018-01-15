package com.okay.myapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.okay.myapp.bean.MyAidlBinder;
import com.okay.myapp.utils.LogUtils;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/15 15:53
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MyService2 extends Service {

    private static final String TAG = MyService2.class.getSimpleName();

    private MyAidlBinder myAidlBinder = new MyAidlBinder(this);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myAidlBinder;
    }

    public void testMethod(String str){

        LogUtils.d(TAG,"MyService2--testMethod2->"+str);
    }
}
