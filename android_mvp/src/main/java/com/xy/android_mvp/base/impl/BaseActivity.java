package com.xy.android_mvp.base.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.Toolbar;

import com.xy.android_mvp.base.IPresenter;
import com.xy.android_mvp.base.IView;

public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity implements IView {

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            int layoutResId = getLayoutResId(savedInstanceState);
            if (layoutResId != 0) {
                setContentView(layoutResId);
                mPresenter = createPresenter(savedInstanceState);
                if (mPresenter != null) {
                    mPresenter.onAttach(this);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        initData(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.onDetach();
        mPresenter = null;
        super.onDestroy();
    }

    protected abstract int getLayoutResId(Bundle savedInstanceState);

    protected abstract P createPresenter(Bundle savedInstanceState);

    protected abstract void initData(Bundle savedInstanceState);

    @Override
    public void showLoading() {
        Toast.makeText(this, "加载中", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setToolBar(Toolbar toolBar, String Title, boolean needBackBtn) {

    }

    @Override
    public void handleError(Exception e) {

        e.printStackTrace();
        hideLoading();
        showMessage(e.getMessage());

    }
}
