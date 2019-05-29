package com.xy.android_mvp.presenter;

import com.xy.android_mvp.base.impl.BasePresenter;
import com.xy.android_mvp.common.Login2Contract;
import com.xy.android_mvp.login.model.LoginListener;
import com.xy.android_mvp.model.Login2ModelImpl;

public class Login2Presenter extends BasePresenter<Login2Contract.Login2View> {

    Login2ModelImpl mainModel;

    public Login2Presenter(){
        mainModel = new Login2ModelImpl();
    }

    public void login2(){

        mainModel.login2("zhangsan", "123456", new LoginListener() {
            @Override
            public void onSuccess() {

                mRootView.onSuccess();
            }

            @Override
            public void onFailed(String message) {

                mRootView.onFailed(message);
            }
        });

    }

}
