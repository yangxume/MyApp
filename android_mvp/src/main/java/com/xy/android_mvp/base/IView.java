package com.xy.android_mvp.base;

import android.widget.Toolbar;

public interface IView {

    void showLoading();

    void hideLoading();

    void showMessage(String message);

    void setToolBar(Toolbar toolBar, String Title, boolean needBackBtn);

    void handleError(Exception e);
}
