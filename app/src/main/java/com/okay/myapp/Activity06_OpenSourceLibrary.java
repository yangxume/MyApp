package com.okay.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/25 16:57
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity06_OpenSourceLibrary extends BaseActivity {

    @BindView(R.id.btn01_Icon)
    Button btn01Icon;
    @BindView(R.id.btn02_Retrofit)
    Button btn02Retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity06_opensource_library);
        ButterKnife.bind(this);




    }

    @OnClick({R.id.btn01_Icon, R.id.btn02_Retrofit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn01_Icon:
                toOtherActivity(Activity06_Icon.class);
                break;
            case R.id.btn02_Retrofit:
                break;
        }
    }
}
