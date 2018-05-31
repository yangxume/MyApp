package com.xy.fresco;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/5/31 18:42
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

        Fresco.initialize(this);
    }
}
