package com.okay.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.okay.myapp.mywebview.ActivitySysWebView;
import com.okay.myapp.mywebview.ActivityX5_Browser;
import com.okay.myapp.mywebview.ActivityX5_FileChooser;
import com.okay.myapp.mywebview.ActivityX5_FullScreen;
import com.okay.myapp.mywebview.ActivityX5_PPT;

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

public class Activity07_WebViewExample extends BaseActivity {


    @BindView(R.id.btn_sys_webview)
    Button btnSysWebview;
    @BindView(R.id.btn_filechoose)
    Button btnFilechoose;
    @BindView(R.id.btn_fullscreen)
    Button btnFullscreen;
    @BindView(R.id.btn_browser)
    Button btnBrowser;
    @BindView(R.id.btn_ppt)
    Button btnPpt;
    @BindView(R.id.btn_office)
    Button btnOffice;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_example);
        ButterKnife.bind(this);


    }

    @OnClick({
            R.id.btn_sys_webview,
            R.id.btn_filechoose,
            R.id.btn_fullscreen,
            R.id.btn_browser,
            R.id.btn_ppt,
            R.id.btn_office
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_sys_webview:
                toOtherActivity(ActivitySysWebView.class);
                break;
            case R.id.btn_filechoose:
                toOtherActivity(ActivityX5_FileChooser.class);
                break;
            case R.id.btn_fullscreen:
                toOtherActivity(ActivityX5_FullScreen.class);
                break;
            case R.id.btn_browser:
                toOtherActivity(ActivityX5_Browser.class);
                break;
            case R.id.btn_ppt:
                toOtherActivity(ActivityX5_PPT.class);
                break;
            case R.id.btn_office:
                toOtherActivity(Activity07_WebView_LoadOffice.class);
                break;


        }
    }
}
