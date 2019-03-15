package com.myapp.leakcanary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Test02_Toast_Activity extends AppCompatActivity {


    private static final String TAG = Test02_Toast_Activity.class.getSimpleName();
    @BindView(R.id.btn_test)
    Button btnTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test02_toast);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_test)
    public void onViewClicked() {

        /**
         * ToastUtil.showShort(this,"Toast  测试 ");
         * 
         * 此种写法当在Activity 中 调用时会造成activity的内存泄露
         *
         * 这是由于 static对象是内部的static对象是比较容易造成内存泄漏的，
         * 因为toast对象是静态的，因此它的生命周期与Application同样长，
         * 因此Activity退出后，它的实例引用依然被toast持有，
         * 导致它无法被回收从而内存泄露了。所以，改为一下写法,
         * 用getApplicationContext（）即可解决问题。
         * ---------------------
         * 原文：https://blog.csdn.net/free_co/article/details/53184530
         */
//        ToastUtil.showShort(this,"Toast  测试 ");
        ToastUtil.showShort(this.getApplicationContext(),"Toast  测试 ");

    }
}
