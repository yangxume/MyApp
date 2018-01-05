package com.okay.myapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.okay.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/5 15:42
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * SlidingPaneLayout的使用挺简单的，下面是它的几个常用方法：
 * setSliderFadeColor : 设置主页面的阴影渐变色。即拉出左侧面板时，右边主页面的渐变阴影色，主页面变得越小则阴影色救越浓。阴影色默认为灰色。
 * setCoveredFadeColor : 设置左侧面板缩进去时的阴影渐变色。
 * setPanelSlideListener : 设置左侧面板的拉出监听器。该监听器实现了下面三个方法：
 * --onPanelClosed : 左侧面板已关闭。
 * --onPanelOpened : 左侧面板已打开。
 * --onPanelSlide : 左侧面板在滑动。
 * openPane : 打开左侧面板。
 * closePane : 关闭左侧面板。
 * isOpen : 判断左侧面板是否打开。
 * Update records:
 */

public class Fragment08_SlidingPaneLayout extends Fragment implements SlidingPaneLayout.PanelSlideListener{

    private static final String TAG = Fragment08_SlidingPaneLayout.class.getSimpleName();
    @BindView(R.id.btn_open_pane)
    Button btnOpenPane;
    @BindView(R.id.btn_close_pane)
    Button btnClosePane;
    @BindView(R.id.sliding_pane_layout)
    SlidingPaneLayout slidingPaneLayout;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment08_slidingpanelayout, container, false);
        unbinder = ButterKnife.bind(this, view);
        slidingPaneLayout.setSliderFadeColor(ContextCompat.getColor(getActivity(),android.R.color.transparent));
        slidingPaneLayout.setPanelSlideListener(this);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_open_pane, R.id.btn_close_pane})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_open_pane:
                slidingPaneLayout.openPane();
                break;
            case R.id.btn_close_pane:
                slidingPaneLayout.closePane();
                break;
        }
    }

    @Override
    public void onPanelSlide(View panel, float slideOffset) {

        Log.e(TAG, "onPanelSlide: " );

    }

    @Override
    public void onPanelOpened(View panel) {

        Log.e(TAG, "onPanelOpened: " );
    }

    @Override
    public void onPanelClosed(View panel) {

        Log.e(TAG, "onPanelClosed: " );
    }
}
