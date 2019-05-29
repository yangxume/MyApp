package com.xy.android_mvp.base;

public interface IPresenter<T extends IView> {

    void initData();

    void onAttach(T view);

    void onDetach();

    T getView();
}
