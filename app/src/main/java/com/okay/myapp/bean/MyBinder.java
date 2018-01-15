package com.okay.myapp.bean;

import android.os.Binder;

import com.okay.myapp.service.MyService;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/15 11:18
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MyBinder extends Binder {

    /**
     * 3、新建一个继承自Binder的类MyBinde
     */
    private static final String TAG = MyBinder.class.getSimpleName();
    private MyService myService;
    private OnTestListener onTestListener;

    public MyBinder(MyService myService) {
        this.myService = myService;
    }

    public void testService(String str){

        myService.serviceMethod(str);
        onTestListener.onTest(str);

    }

    public void setOnTestListener(OnTestListener onTestListener) {
        this.onTestListener = onTestListener;
    }

    public interface OnTestListener{
        void onTest(String str);
    }
}
