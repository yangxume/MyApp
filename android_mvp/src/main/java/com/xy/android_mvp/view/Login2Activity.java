package com.xy.android_mvp.view;


import android.os.Bundle;

import com.xy.android_mvp.R;
import com.xy.android_mvp.base.impl.BaseActivity;
import com.xy.android_mvp.common.Login2Contract;
import com.xy.android_mvp.presenter.Login2Presenter;

public class Login2Activity extends BaseActivity<Login2Presenter>
implements Login2Contract.Login2View {

    @Override
    protected int getLayoutResId(Bundle savedInstanceState) {
        return R.layout.activity_login;
    }

    @Override
    protected Login2Presenter createPresenter(Bundle savedInstanceState) {
        return new Login2Presenter();
    }

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailed(String message) {

    }

    public void login(){
        mPresenter.login2();
    }
}
