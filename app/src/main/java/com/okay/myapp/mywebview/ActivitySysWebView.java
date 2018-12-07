package com.okay.myapp.mywebview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.okay.myapp.BaseActivity;
import com.okay.myapp.R;

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

public class ActivitySysWebView extends BaseActivity {

    private static final String TAG = ActivitySysWebView.class.getSimpleName();

    @BindView(R.id.webview)
    WebView mWebview;


//    private String url_163 = "http://news.163.com/";
//    private String url_baidu = "https://www.baidu.com/";
//    private String url_ppt = "http://hotfix.oos.xk12.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fhotfix.wopi.xk12.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_UTXWnJXLd6.pptx&action=embedview&sc=031184784059&token=c749127ad9cc40fb897dceb110c6ad3d&system_id=61951185794&md5=rw_UTXWnJXLd6.pptx&isokaypad=1";
//    private String oos_url = "http://oos.okjiaoyu.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fwopi.okjiaoyu.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_W0nKnxXHNu.ppt&action=embedview&sc=030295951894&system_id=61951185794&token=a6d973fba95d4befaf0219f27df1f24f&md5=rw_W0nKnxXHNu.ppt&isokaypad=1";
//    private String owa_url = "http://owa.okjiaoyu.cn/op/embed.aspx?src=http://rw.okjiaoyu.cn/rw_W0nKLUmrf2.ppt";
//      private String url_01 = "http://hotfix.oos.xk12.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fhotfix.wopi.xk12.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_VYHS5tb14I.ppt&action=embedview&sc=032105722547&token=c31a7b9d3f124cb097e642626dabf600&system_id=61951185794&md5=rw_VYHS5tb14I.ppt&isokaypad=1";

    String url = "http://oos.okjiaoyu.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fwopi.okjiaoyu.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_W0nKnxXHNu.ppt&action=embedview&sc=030295951894&system_id=61951185794&token=a6d973fba95d4befaf0219f27df1f24f&md5=rw_W0nKnxXHNu.ppt&isokaypad=1";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sys_webview);
        ButterKnife.bind(this);

        initWebView();

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

        mWebview.loadUrl(url);

        /**

         一般很少会用到这个，用WebView组件显示普通网页时一般会出现横向滚动条，这样会导致页面查看起来非常不方便。LayoutAlgorithm是一个枚举，用来控制html的布局，总共有三种类型：
         NORMAL：正常显示，没有渲染变化。
         SINGLE_COLUMN：把所有内容放到WebView组件等宽的一列中。
         NARROW_COLUMNS：可能的话，使所有列的宽度不超过屏幕宽度。
         *
         */
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

//        mWebview.setWebViewClient(new WebViewClient() {
//
//
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
//
//                return true;
//            }
//
//            @Override
//            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//                handler.proceed(); //支持http
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//                LogUtils.d(TAG, "onPageStarted方法：" + url);
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                super.onPageFinished(view, url);
//                LogUtils.d(TAG, "onPageFinished方法：" + url);
//
//                mWebview.loadUrl(url);
//
//            }
//
//            @Override
//            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                super.onReceivedError(view, request, error);
//                LogUtils.d(TAG, "onPageFinished方法：" + error.toString());
//
//            }
//        });


        mWebview.setWebChromeClient(webChromeClient);
    }

    WebChromeClient.CustomViewCallback mCustomViewCallback;
    View mCustomView;

    /**
     * 处理全屏回调
     */
    private WebChromeClient webChromeClient = new WebChromeClient() {

        @Override
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
              setFullScreen(true);
              mCustomView = view;
              mCustomViewCallback = callback;
              if (mCustomView != null){
                  ViewGroup parent = (ViewGroup) mWebview.getParent();
                  parent.removeView(mCustomView);
                  mCustomView = null;
              }
        }

        @Override
        public void onHideCustomView() {

            setFullScreen(false);
            if (mCustomView != null){
                ViewGroup parent = (ViewGroup) mWebview.getParent();
                parent.removeView(mCustomView);
                mCustomView = null;
            }
            
            if (mCustomViewCallback != null){
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
}
