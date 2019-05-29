package com.xy.android_mvp.login.model;

import android.text.TextUtils;

import com.xy.android_mvp.login.ContractInterface;

public class LoginModel implements ContractInterface.IModel {

    String userName = "xuyang";
    String passWord = "123456";

    @Override
    public void login(String userName,String passWord,LoginListener loginListener) {

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
