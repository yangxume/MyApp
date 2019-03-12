package com.okay.myapp.mywebview;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.okay.myapp.BaseActivity;
import com.okay.myapp.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/28 17:27
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description   https://www.cnblogs.com/kelina2mark/p/6097978.html
 * <p>
 * Update records:
 */

public class WebViewVideoActivity extends BaseActivity {

    private WebView mWebView;
    private String urlVideo = "https://rv.okjiaoyu.cn/rv_14q4X1oJOes.low.h264.mp4";

    /** 视频全屏参数 */
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private View customView;
    private FrameLayout fullscreenContainer;
    private WebChromeClient.CustomViewCallback customViewCallback;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_webviewvideo);

        mWebView = (WebView) findViewById(R.id.webview);

//        loadUrlNet();
//        loadUrlAssets();
//        loadUrlLocal();
//        loadData();

        loadVideoFullScreen();

    }

    @Override
    protected void onStop() {
        super.onStop();
        mWebView.reload();
    }

    /** 展示网页界面 **/
    public void loadVideoFullScreen(){

        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true); // 关键点
        webSettings.setAllowFileAccess(true); // 允许访问文件
        webSettings.setSupportZoom(true); // 支持缩放
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); // 不加载缓存内容

        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                mWebView.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebChromeClient(getWebChromeClient());
        // 加载Web地址
        mWebView.loadUrl(urlVideo);
    }

    @NonNull
    private WebChromeClient getWebChromeClient() {
        return new WebChromeClient() {

            /*** 视频播放相关的方法 **/
            @Override
            public View getVideoLoadingProgressView() {
                FrameLayout frameLayout = new FrameLayout(WebViewVideoActivity.this);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT));
                return frameLayout;
            }

            @Override
            public void onShowCustomView(View view, CustomViewCallback callback) {
                showCustomView(view, callback);
            }

            @Override
            public void onHideCustomView() {
                hideCustomView();
            }
        };
    }

    /** 视频播放全屏 **/
    private void showCustomView(View view, WebChromeClient.CustomViewCallback callback) {
        // if a view already exists then immediately terminate the new one
        if (customView != null) {
            callback.onCustomViewHidden();
            return;
        }

        WebViewVideoActivity.this.getWindow().getDecorView();

        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        fullscreenContainer = new FullscreenHolder(WebViewVideoActivity.this);
        fullscreenContainer.addView(view, COVER_SCREEN_PARAMS);
        decor.addView(fullscreenContainer, COVER_SCREEN_PARAMS);
        customView = view;
        setStatusBarVisibility(false);
        customViewCallback = callback;
    }

    /** 隐藏视频全屏 */
    private void hideCustomView() {
        if (customView == null) {
            return;
        }
        setStatusBarVisibility(true);
        FrameLayout decor = (FrameLayout) getWindow().getDecorView();
        decor.removeView(fullscreenContainer);
        fullscreenContainer = null;
        customView = null;
        customViewCallback.onCustomViewHidden();
        mWebView.setVisibility(View.VISIBLE);
    }

    /** 全屏容器界面 */
    static class FullscreenHolder extends FrameLayout {

        public FullscreenHolder(Context ctx) {
            super(ctx);
            setBackgroundColor(ctx.getResources().getColor(android.R.color.black));
        }

        @Override
        public boolean onTouchEvent(MotionEvent evt) {
            return true;
        }
    }

    private void setStatusBarVisibility(boolean visible) {
        int flag = visible ? 0 : WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    //方式1. 加载一个网页：
    private void loadUrlNet() {
        mWebView.loadUrl("https://rv.okjiaoyu.cn/rv_14q4X1oJOes.low.h264.mp4");
    }

    //方式2：加载apk包中的html页面
    private void loadUrlAssets() {
        mWebView.loadUrl("file:///android_asset/mp4.html");
    }

    //方式3：加载手机本地的html页面
    private void loadUrlLocal() {
//        mWebView.loadUrl("content://com.android.htmlfileprovider/sdcard/test.html");
    }

    // 方式4： 加载 HTML 页面的一小段内容
    private void loadData() {

//        mWebView.loadData(String data, String mimeType, String encoding)
        // 参数说明：
        // 参数1：需要截取展示的内容
        // 内容里不能出现 ’#’, ‘%’, ‘\’ , ‘?’ 这四个字符，若出现了需用 %23, %25, %27, %3f 对应来替代，否则会出现异常
        // 参数2：展示内容的类型
        // 参数3：字节码

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                /** 回退键 事件处理 优先级:视频播放全屏-网页回退-关闭页面 */
                if (mWebView.canGoBack()) {
                    mWebView.goBack();
                } else {
                    finish();
                }
                return true;
            default:
                return super.onKeyUp(keyCode, event);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (null != mWebView){
            ViewGroup parent = (ViewGroup) mWebView.getParent();
            parent.removeView(mWebView);
            mWebView.destroy();
        }
    }
}
