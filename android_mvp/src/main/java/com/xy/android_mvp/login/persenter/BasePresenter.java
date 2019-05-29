package com.xy.android_mvp.login.persenter;

import com.xy.android_mvp.login.ContractInterface;
import com.xy.android_mvp.login.view.IView;

import java.lang.ref.WeakReference;

public class BasePresenter {

    protected ContractInterface.IModel iModel;
    protected WeakReference<IView> iViewWeakReference;

}
