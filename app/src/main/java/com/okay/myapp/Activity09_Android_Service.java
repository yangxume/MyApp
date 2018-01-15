package com.okay.myapp;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.okay.myapp.bean.IMyCallbackListener;
import com.okay.myapp.bean.MyBinder;
import com.okay.myapp.service.MyService;
import com.okay.myapp.service.MyService2;
import com.okay.myapp.utils.LogUtils;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/15 10:51
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity09_Android_Service extends BaseActivity {


    private static final String TAG = Activity09_Android_Service.class.getSimpleName();
    private Button btn_binder;
    private Button btn_aidl_binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity09_android_service);

        initViews();

        testBinder();
        testAidlBinder();

    }

    private void initViews() {
        btn_binder = findViewById(R.id.btn_binder);
        btn_aidl_binder = findViewById(R.id.btn_aidl_binder);
    }

    private IMyCallbackListener.Stub iMyCallbackListener = new IMyCallbackListener.Stub(){

        @Override
        public void onRespond(String str) throws RemoteException {
            Log.d(TAG, "onRespond: "+str);
        }
    };

    private IMyAidlInterface myService2;
    ServiceConnection m2Connection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService2 = IMyAidlInterface.Stub.asInterface(service);
            try {
                myService2.resisterListener(iMyCallbackListener);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void testAidlBinder() {


        final Intent intent = new Intent(ctx, MyService2.class);
        bindService(intent, m2Connection, BIND_AUTO_CREATE);
        btn_aidl_binder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                try {
                    myService2.testMethod("hi i am from testAidlBinder");
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    /**
     * 同一进程间activity 和 service通信： Binder
     * 基本用法即同进程下Activity与Service双向通信，先描述整体实现过程然后直接上代码：
     * 新建一个继承自Service的类MyService，然后在AndroidManifest.xml里注册这个Service
     * <p>
     * Activity里面使用bindService方式启动MyService，
     * 也就是绑定了MyService（到这里实现了绑定，Activity与Service通信的话继续下面的步骤）
     * <p>
     * 新建一个继承自Binder的类MyBinder
     * <p>
     * 在MyService里实例化一个MyBinder对象mBinder，并在onBind回调方法里面返回这个mBinder对象
     * <p>
     * 第2步bindService方法需要一个ServiceConnection类型的参数，在ServiceConnection里可以取到一个IBinder对象，
     * 就是第4步onBinder返回的mBinder对象（也就是在Activity里面拿到了Service里面的mBinder对象）
     * <p>
     * 在Activity里面拿到mBinder之后就可以调用这个binder里面的方法了（也就是可以给Service发消息了），
     * 需要什么方法在MyBinder类里面定义实现就行了。如果需要Service给Activity发消息的话，通过这个binder注册一个自定义回调即可。
     */
    private MyBinder myBinder;

    private void testBinder() {

        ServiceConnection serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {

//            第4步onBinder返回的mBinder对象
                myBinder = (MyBinder) service;
                myBinder.setOnTestListener(new MyBinder.OnTestListener() {
                    @Override
                    public void onTest(String str) {

                        LogUtils.d(TAG, "activity receive msg from MyService: " + str);

                    }
                });

            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };

        /**
         2、Activity里面使用bindService方式启动MyService，
         也就是绑定了MyService（到这里实现了绑定，Activity与Service通信的话继续下面的步骤）
         */
        Intent intent = new Intent(ctx, MyService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);

        btn_binder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮调用mBinder里面的方法，发送消息给Service
                myBinder.testService("hi , test mybinder , msg from activity to MyService");
            }
        });
    }


}
