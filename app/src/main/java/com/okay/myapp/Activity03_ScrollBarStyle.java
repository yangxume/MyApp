package com.okay.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/15 14:24
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity03_ScrollBarStyle extends BaseActivity {

    @BindView(R.id.ll_main)
    LinearLayout llMain;
    private String TAG = Activity03_ScrollBarStyle.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollbarstyle);
        ButterKnife.bind(this);

        init();
    }

    private void init() {

        for (int i = 0; i < 30; i++) {

            TextView textView = new TextView(this);
            textView.setText("tv_"+i);
            textView.setWidth(200);
            textView.setHeight(100);
            textView.setTextSize(20);
            textView.setTextColor(Color.BLUE);
            llMain.addView(textView);

        }

    }
}
