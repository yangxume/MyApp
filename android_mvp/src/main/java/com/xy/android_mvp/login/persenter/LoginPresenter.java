package com.xy.android_mvp.login.persenter;


import com.xy.android_mvp.login.ContractInterface;
import com.xy.android_mvp.login.model.LoginListener;
import com.xy.android_mvp.login.model.LoginModel;
import com.xy.android_mvp.login.view.IView;

import java.lang.ref.WeakReference;

public class LoginPresenter extends BasePresenter implements ContractInterface.IPresenter {


    public LoginPresenter(ContractInterface.ILoginView loginView) {

        iModel = new LoginModel();
        iViewWeakReference = new WeakReference<IView>(loginView);

    }

    @Override
    public void login() {

        if (iModel != null && iViewWeakReference != null
                && iViewWeakReference.get() != null) {

            ContractInterface.ILoginView loginview = (ContractInterface.ILoginView) iViewWeakReference.get();
            String userName = loginview.getUserName();
            String passWord = loginview.getPassWord();

            iModel.login(userName,passWord, new LoginListener() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onFailed() {

                }
            });

        }


    }
}
