package com.okay.myapp;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/7/5 17:04
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class Activity11_PopupWindow extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = Activity11_PopupWindow.class.getSimpleName();
    private Context context;
    private Button btn1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity11_popup_window);
        context = Activity11_PopupWindow.this;
        initView();
        initData();
    }

    private void initData() {

    }

    private void initView() {

        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

    }

    private void showPopupWindow() {

//        // 用于PopupWindow的View
//        View contentView= LayoutInflater.from(context).inflate(R.layout.activity11_layout_popupwindow_view, null, false);
//        // 创建PopupWindow对象，其中：
//        // 第一个参数是用于PopupWindow中的View，第二个参数是PopupWindow的宽度，
//        // 第三个参数是PopupWindow的高度，第四个参数指定PopupWindow能否获得焦点
//        PopupWindow window=new PopupWindow(contentView, 100, 100, true);
//        // 设置PopupWindow的背景
//        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        // 设置PopupWindow是否能响应外部点击事件
//        window.setOutsideTouchable(true);
//        // 设置PopupWindow是否能响应点击事件
//        window.setTouchable(true);
//        // 显示PopupWindow，其中：
//        // 第一个参数是PopupWindow的锚点，第二和第三个参数分别是PopupWindow相对锚点的x、y偏移
//        window.showAsDropDown(anchor, xoff, yoff);
//        // 或者也可以调用此方法显示PopupWindow，其中：
//        // 第一个参数是PopupWindow的父View，第二个参数是PopupWindow相对父View的位置，
//        // 第三和第四个参数分别是PopupWindow相对父View的x、y偏移
//        // window.showAtLocation(parent, gravity, x, y);


        // 一个自定义的布局，作为显示的内容

        // 真实环境中要赋值
        int layoutId = R.layout.activity11_layout_popupwindow_view;
        // 布局ID
        View contentView = LayoutInflater.from(context).inflate(layoutId, null);

        final PopupWindow popupWindow = new PopupWindow(contentView,
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);
        // 如果不设置PopupWindow的背景，有些版本就会出现一个问题：无论是点击外部区域还是Back键都无法dismiss弹框
        // 这里单独写一篇文章来分析
        popupWindow.setBackgroundDrawable(new ColorDrawable());
       // 设置好参数之后再show
        popupWindow.showAsDropDown(btn1);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn1:
                showPopupWindow();
                break;


        }

    }
}
