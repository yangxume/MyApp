package com.okay.myapp.bean;

import android.os.RemoteCallbackList;
import android.os.RemoteException;

import com.okay.myapp.IMyAidlInterface;
import com.okay.myapp.service.MyService2;
import com.okay.myapp.utils.LogUtils;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/15 15:50
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MyAidlBinder extends IMyAidlInterface.Stub {

    private static final String TAG = MyAidlBinder.class.getSimpleName();

    private MyService2 myService;
    private RemoteCallbackList<IMyCallbackListener> remoteCallbackList = new RemoteCallbackList<>();

    public MyAidlBinder(MyService2 myService) {
        this.myService = myService;
    }

    @Override
    public void testMethod(String str) throws RemoteException {

        myService.testMethod(str);

        LogUtils.d(TAG, "receivew msg:" + str);

        int count = remoteCallbackList.beginBroadcast();
        for (int i = 0;i<count;i++)
            remoteCallbackList.getBroadcastItem(i).onRespond(str);

        remoteCallbackList.finishBroadcast();

    }

    @Override
    public void resisterListener(IMyCallbackListener listener) throws RemoteException {

        remoteCallbackList.register(listener);
    }

    @Override
    public void unResisterListener(IMyCallbackListener listener) throws RemoteException {
        remoteCallbackList.unregister(listener);
    }


}
