package com.xy.android_mvp.model;


import android.text.TextUtils;

import com.xy.android_mvp.common.Login2Contract;
import com.xy.android_mvp.login.model.LoginListener;

public class Login2ModelImpl implements Login2Contract.Login2Model {


    String userName = "xuyang";
    String passWord = "123456";

    @Override
    public void login2(String userName, String passWord, LoginListener loginListener) {

        if (TextUtils.isEmpty(userName)){
            return;
        }

        if (TextUtils.isEmpty(passWord)){
            return;
        }

        if (userName.equals(userName) && passWord.equals(passWord)){
            loginListener.onSuccess();
        }else{
            loginListener.onFailed();
        }
    }
}