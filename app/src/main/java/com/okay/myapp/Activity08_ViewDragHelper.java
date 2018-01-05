package com.okay.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.okay.myapp.ui.fragment.Fragment08_Custom_Layout;
import com.okay.myapp.ui.fragment.Fragment08_DrawerLayout;
import com.okay.myapp.ui.fragment.Fragment08_SlidingPaneLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/4 15:29
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity08_ViewDragHelper extends BaseActivity {

    public static final String TAG = Activity08_ViewDragHelper.class.getSimpleName();
    @BindView(R.id.btn_SlidingPaneLayout)
    Button btnSlidingPaneLayout;
    @BindView(R.id.btn_DrawerLayout)
    Button btnDrawerLayout;
    @BindView(R.id.fl_main)
    FrameLayout flMain;
    @BindView(R.id.btn_custom_layout)
    Button btnCustomLayout;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity08_viewdraghelper);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_SlidingPaneLayout,
            R.id.btn_DrawerLayout,
            R.id.btn_custom_layout
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_SlidingPaneLayout:

                flMain.removeAllViews();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fl_main, new Fragment08_SlidingPaneLayout());
                transaction.commit();

                break;
            case R.id.btn_DrawerLayout:
                flMain.removeAllViews();
                FragmentManager fm2 = getSupportFragmentManager();
                FragmentTransaction transaction1 = fm2.beginTransaction();
                transaction1.replace(R.id.fl_main, new Fragment08_DrawerLayout());
                transaction1.commit();

                break;

            case R.id.btn_custom_layout:
                flMain.removeAllViews();
                FragmentManager fm3 = getSupportFragmentManager();
                FragmentTransaction transaction3 = fm3.beginTransaction();
                transaction3.replace(R.id.fl_main, new Fragment08_Custom_Layout());
                transaction3.commit();

                break;
        }
    }
}
