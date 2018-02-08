package com.okay.myapp.mywebview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.okay.myapp.BaseActivity;
import com.okay.myapp.R;
import com.okay.myapp.utils.LogUtils;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/28 10:12
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class ActivityX5_OpenPPT extends BaseActivity {

    @BindView(R.id.x5_webview)
    X5WebView x5Webview;

    String ppt = "http://10.60.0.169/p/PowerPointFrame.aspx?WOPISrc=http://10.60.0.201:8080/wopi/files/http://rw.okjiaoyu.cn/rw_0036a751376baf1ffd4fad61.ppt&&action=preloadview";
    String doc = "http://10.60.0.169/wv/wordviewerframe.aspx?WOPISrc=http://10.60.0.201:8080/wopi/files/http://rc.okjiaoyu.cn/rc_hrfWR33095.ori.doc&&action=preloadview";
    String pdf = "http://10.60.0.169/wv/wordviewerframe.aspx?PdfMode=1&WOPISrc=http://10.60.0.201:8080/wopi/files/http://rc.okjiaoyu.cn/rc_FFbTLRv4tO.pdf&action=preloadview";
    String excel = "http://10.60.0.169/x/_layouts/xlviewerinternal.aspx?WOPISrc=http://10.60.0.201:8080/wopi/files/http://rc.okjiaoyu.cn/rc_FFjOyp4B56.xls&action=preloadview";


    private Context ctx;
    private static final String TAG = ActivityX5_OpenPPT.class.getSimpleName();
    ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_x5webview_ppt);
        ButterKnife.bind(this);
        ctx = ActivityX5_OpenPPT.this;

        initWebView();

        //支持javascript
        webSetting.setJavaScriptEnabled(true);
        // 设置可以支持缩放
        webSetting.setSupportZoom(true);
        // 设置出现缩放工具
        webSetting.setBuiltInZoomControls(true);
        webSetting.setDisplayZoomControls(false);
        //扩大比例的缩放
        webSetting.setUseWideViewPort(true);
        //自适应屏幕
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webSetting.setLoadWithOverviewMode(true);

    }

    WebSettings webSetting;

    private void initWebView() {

        webSetting = x5Webview.getSettings();
        webSetting.setAppCachePath(ctx.getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(ctx.getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(ctx.getDir("geolocation", 0)
                .getPath());


        x5Webview.loadUrl(ppt);
        x5Webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                sslErrorHandler.proceed();
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String url) {

                if (TextUtils.isEmpty(url)) {
                    Toast.makeText(ctx, "url is null", Toast.LENGTH_LONG).show();
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, url);
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                LogUtils.d(TAG, "onPageStarted");
            }

            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                LogUtils.d(TAG, "onPageFinished");

            }

            @Override
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                LogUtils.d(TAG, "onReceivedError");
            }
        });

        x5Webview.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsConfirm(WebView webView, String s, String s1, JsResult jsResult) {
                return super.onJsConfirm(webView, s, s1, jsResult);
            }

            View myVideoView;
            View myNormalView;
            IX5WebChromeClient.CustomViewCallback callback;

            @Override
            public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
                X5WebView normalView = x5Webview;
                ViewGroup viewGroup = (ViewGroup) normalView.getParent();
                viewGroup.removeView(normalView);
                viewGroup.addView(view);
                myVideoView = view;
                myNormalView = normalView;
                callback = customViewCallback;
            }

            @Override
            public void onHideCustomView() {
                if (callback != null) {
                    callback.onCustomViewHidden();
                    callback = null;
                }
                if (myVideoView != null) {
                    ViewGroup viewGroup = (ViewGroup) myVideoView.getParent();
                    viewGroup.removeView(myVideoView);
                    viewGroup.addView(myNormalView);
                }
            }

            @Override
            public boolean onJsAlert(WebView webView, String s, String s1, JsResult jsResult) {
                return super.onJsAlert(webView, s, s1, jsResult);
            }
        });

        x5Webview.loadUrl(ppt);
    }
}
