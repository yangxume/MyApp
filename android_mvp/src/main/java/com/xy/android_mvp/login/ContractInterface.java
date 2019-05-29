package com.xy.android_mvp.login;

import com.xy.android_mvp.login.model.LoginListener;
import com.xy.android_mvp.login.view.IView;

public interface ContractInterface {

    interface IModel {
        void login(String userName, String passWord, LoginListener loginListener);
    }

    interface IPresenter {

        void login();
    }

    interface ILoginView extends IView {

        String getUserName();

        String getPassWord();

        void onLoginSuccess();

        void onLoginFailed();

    }

}
