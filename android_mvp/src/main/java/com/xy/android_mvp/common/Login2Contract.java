package com.xy.android_mvp.common;

import com.xy.android_mvp.base.IView;
import com.xy.android_mvp.login.model.LoginListener;

import java.util.List;
import java.util.Map;

public interface Login2Contract {

    interface Login2Model {
        void login2(String userName,String passWord,LoginListener loginListener);
    }

    interface Login2View extends IView {

        void onSuccess();
        void onFailed(String message);

    }

    interface Presenter {
        void requestList(Map<String,String> params);
    }

}
