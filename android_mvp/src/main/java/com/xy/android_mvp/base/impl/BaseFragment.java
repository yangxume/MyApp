package com.xy.android_mvp.base.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.xy.android_mvp.base.IPresenter;
import com.xy.android_mvp.base.IView;

public abstract class BaseFragment<P extends IPresenter> extends Fragment implements IView {

    public P mPresenter;

    public FragmentActivity activity;
    private View parentView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        parentView = inflater.inflate(getLayoutResId(), container);
        activity = getActivity();

        return parentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter != null)
            mPresenter.onAttach(this);
        finishCreateView();
    }

    public abstract P createPresenter();
    public abstract void finishCreateView();
    public abstract int getLayoutResId();

    @Override
    public void showLoading() {
        Toast.makeText(activity, "加载中", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void hideLoading() {
        Toast.makeText(activity, "加载完成", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
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
