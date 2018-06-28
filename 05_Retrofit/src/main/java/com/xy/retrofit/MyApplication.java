package com.xy.retrofit;

import android.app.Application;
import android.content.Context;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/6/7 11:27
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

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }


}
