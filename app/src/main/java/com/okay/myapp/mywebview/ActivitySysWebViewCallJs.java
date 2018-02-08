package com.okay.myapp.mywebview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.okay.myapp.BaseActivity;
import com.okay.myapp.R;
import com.okay.myapp.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

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

public class ActivitySysWebViewCallJs extends BaseActivity {

    private static final String TAG = ActivitySysWebViewCallJs.class.getSimpleName();

    @BindView(R.id.webview)
    WebView mWebview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_webview_calljs);
        ButterKnife.bind(this);

        initWebView();

        // 加载JS代码
        // 格式规定为:file:///android_asset/文件名.html
        mWebview.loadUrl("file:///android_asset/javascript.html");
    }

    /**
     * 初始化web view
     */
    private void initWebView() {
        WebSettings settings = mWebview.getSettings();
        //支持js
        settings.setJavaScriptEnabled(true);
        //适配屏幕
        settings.setUseWideViewPort(true); //适配屏幕
        settings.setDomStorageEnabled(true);
        //支持缩放
        settings.setSupportZoom(true);
        //显示缩放工具
        settings.setBuiltInZoomControls(true);
        mWebview.setFocusable(false);
        //设置默认的字体大小，默认为16，有效值区间在1-72之间。
        settings.setDefaultFontSize(18);

        // 设置与Js交互的权限
        settings.setJavaScriptEnabled(true);

        // 通过addJavascriptInterface()将Java对象映射到JS对象
        //参数1：Javascript对象名
        //参数2：Java对象名
        mWebview.addJavascriptInterface(new AndroidtoJs(), "resExceptionMsg");//AndroidtoJS类对象映射到js的test对象

        /**

         一般很少会用到这个，用WebView组件显示普通网页时一般会出现横向滚动条，这样会导致页面查看起来非常不方便。LayoutAlgorithm是一个枚举，用来控制html的布局，总共有三种类型：
         NORMAL：正常显示，没有渲染变化。
         SINGLE_COLUMN：把所有内容放到WebView组件等宽的一列中。
         NARROW_COLUMNS：可能的话，使所有列的宽度不超过屏幕宽度。
         *
         */
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

        mWebview.setWebChromeClient(webChromeClient);
    }

    WebChromeClient.CustomViewCallback mCustomViewCallback;
    View mCustomView;

    /**
     * 处理全屏回调
     */
    private WebChromeClient webChromeClient = new WebChromeClient() {

        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {
            setFullScreen(true);
            mCustomView = view;
            mCustomViewCallback = callback;
            if (mCustomView != null) {
                ViewGroup parent = (ViewGroup) mWebview.getParent();
                parent.removeView(mCustomView);
                mCustomView = null;
            }
        }

        @Override
        public void onHideCustomView() {

            setFullScreen(false);
            if (mCustomView != null) {
                ViewGroup parent = (ViewGroup) mWebview.getParent();
                parent.removeView(mCustomView);
                mCustomView = null;
            }

            if (mCustomViewCallback != null) {
                mCustomViewCallback.onCustomViewHidden();
                mCustomViewCallback = null;
            }

        }
    };

    public void setFullScreen(boolean fullScreen) {

//        if (fullScreen){
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            mWebview.setVisibility(View.GONE);
//        }else{
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
//            mWebview.setVisibility(View.VISIBLE);
//        }
//
//        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        }else{
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        }

    }

    public class AndroidtoJs extends Object {

        // 定义JS需要调用的方法
        // 被JS调用的方法必须加入@JavascriptInterface注解
        @JavascriptInterface
        public void sendResExceptionMsg(String msg) {
            LogUtils.d(TAG,"JS调用了Android的sendResExceptionMsg方法");
            Toast.makeText(ActivitySysWebViewCallJs.this,msg,Toast.LENGTH_LONG).show();
        }
    }


}
