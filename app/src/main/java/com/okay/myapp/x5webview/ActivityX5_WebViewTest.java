package com.okay.myapp.x5webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.okay.myapp.BaseActivity;
import com.okay.myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/27 16:11
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class ActivityX5_WebViewTest extends BaseActivity {


    @BindView(R.id.btn_filechoose)
    Button btnFilechoose;
    @BindView(R.id.btn_fullscreen)
    Button btnFullscreen;
    @BindView(R.id.btn_browser)
    Button btnBrowser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5webview_test);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_filechoose, R.id.btn_fullscreen, R.id.btn_browser})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_filechoose:
                toOtherActivity(ActivityX5_FileChooser.class);
                break;
            case R.id.btn_fullscreen:
                toOtherActivity(ActivityX5_FullScreen.class);
                break;
            case R.id.btn_browser:
                toOtherActivity(ActivityX5_Browser.class);
                break;
        }
    }
}
