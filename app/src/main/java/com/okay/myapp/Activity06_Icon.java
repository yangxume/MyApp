package com.okay.myapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/25 18:19
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description  https://github.com/mikepenz/Android-Iconics
 * <p>
 * Update records:
 */

public class Activity06_Icon extends BaseActivity {

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity06_icon);
        ButterKnife.bind(this);

//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IconicsDrawable iconicsDrawable = new IconicsDrawable(this)
                .icon(FontAwesome.Icon.faw_android)
                .color(Color.RED)
                .sizeDp(50);

        iv1.setImageDrawable(iconicsDrawable);


    }
}
