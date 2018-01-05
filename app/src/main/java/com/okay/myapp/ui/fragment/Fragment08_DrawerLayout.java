package com.okay.myapp.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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
 * DrawerLayout也是android-support-v4.jar中新加的抽屉式布局，
 * 它的用法更加类似于滑出式菜单的开源框架SlidingMenu，
 * 有关SlidingMenu的说明参见《Android开发笔记（一百零一）滑出式菜单》。
 * DrawerLayout应该也是Android与时俱进的产物，它比SlidingPaneLayout更强大，
 * 不但可以拉出左侧抽屉面板，还可以拉出右侧抽屉面板。左侧面板与右侧面板的区别在于，
 * 左侧面板在布局文件中的layout_gravity属性为left，而右侧面板在布局文件中的layout_gravity属性为right。
 * <p>
 * 下面是DrawerLayout的几个常用方法说明：
 * setDrawerShadow : 设置主页面的渐变阴影图形。
 * addDrawerListener : 添加抽屉面板的拉出监听器。该监听器实现了下面三个方法：
 * --onDrawerSlide : 抽屉面板在滑动。
 * --onDrawerOpened : 抽屉面板已打开。
 * --onDrawerClosed : 抽屉面板已关闭。
 * --onDrawerStateChanged : 抽屉面板的状态发生变化。
 * removeDrawerListener : 移除抽屉面板的拉出监听器。
 * closeDrawers : 关闭所有抽屉面板。
 * openDrawer : 打开指定抽屉面板。
 * closeDrawer : 关闭指定抽屉面板。
 * isDrawerOpen : 判断指定抽屉面板是否打开。
 * <p>
 * <p>
 * <p>
 * Update records:
 */

public class Fragment08_DrawerLayout extends Fragment {

    @BindView(R.id.btn_open_left_drawer)
    Button btnOpenLeftDrawer;
    @BindView(R.id.btn_open_right_drawer)
    Button btnOpenRightDrawer;
    @BindView(R.id.drawerlayout)
    DrawerLayout drawerlayout;
    Unbinder unbinder;
    @BindView(R.id.lv_drawer_left)
    ListView lvDrawerLeft;
    @BindView(R.id.lv_drawer_right)
    ListView lvDrawerRight;

    private
    String[] titleArray = {"首页", "新闻", "娱乐", "博客", "论坛"};

    private
    String[] settingArray = {"我的", "设置", "关于"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


//        return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment08_drawerlayout, container, false);
        unbinder = ButterKnife.bind(this, view);
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

    @OnClick({R.id.btn_open_left_drawer, R.id.btn_open_right_drawer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_open_left_drawer:
                openLeftDrawer();
                break;
            case R.id.btn_open_right_drawer:
                openRightDrawer();
                break;
        }
    }

    private void openLeftDrawer() {


        ArrayAdapter<String> left_adapter = new
                ArrayAdapter<>(getActivity(),

                android.R.layout.simple_list_item_1, android.R.id.text1,titleArray);

        lvDrawerLeft.setAdapter(left_adapter);
        drawerlayout.openDrawer(lvDrawerLeft);
    }
    private void openRightDrawer() {
        ArrayAdapter<String> right_adapter = new
                ArrayAdapter<>(getActivity(),

                android.R.layout.simple_list_item_1, android.R.id.text1,settingArray);
        lvDrawerRight.setAdapter(right_adapter);
        drawerlayout.openDrawer(lvDrawerRight);

    }

}
