package com.xy.android_mvp.base.impl;

import com.xy.android_mvp.base.IPresenter;
import com.xy.android_mvp.base.IView;

public  class BasePresenter<V extends IView>
        implements IPresenter<V> {

    public V mRootView;

    public BasePresenter(){
        initData();
    }

    @Override
    public void initData() {

    }

    @Override
    public void onAttach(V view) {
        this.mRootView = view;
    }

    @Override
    public void onDetach() {
        this.mRootView = null;
    }

    @Override
    public V getView() {
        return mRootView;
    }
}
