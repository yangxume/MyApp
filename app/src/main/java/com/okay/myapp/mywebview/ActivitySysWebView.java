package com.okay.myapp.mywebview;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;

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

//https://blog.csdn.net/yllp_1230/article/details/80655350
public class ActivitySysWebView extends BaseActivity {

    private static final String TAG = ActivitySysWebView.class.getSimpleName();

    @BindView(R.id.webview)
    WebView mWebview;

//    private String url_163 = "http://news.163.com/";
//    private String url_baidu = "https://www.baidu.com/";
//    private String url_ppt = "http://hotfix.oos.xk12.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fhotfix.wopi.xk12.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_UTXWnJXLd6.pptx&action=embedview&sc=031184784059&token=c749127ad9cc40fb897dceb110c6ad3d&system_id=61951185794&md5=rw_UTXWnJXLd6.pptx&isokaypad=1";
//    private String oos_url = "http://oos.okjiaoyu.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fwopi.okjiaoyu.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_W0nKnxXHNu.ppt&action=embedview&sc=030295951894&system_id=61951185794&token=a6d973fba95d4befaf0219f27df1f24f&md5=rw_W0nKnxXHNu.ppt&isokaypad=1";
//    private String owa_url = "http://owa.okjiaoyu.cn/op/embed.aspx?src=http://rw.okjiaoyu.cn/rw_W0nKLUmrf2.ppt";
//    private String url_01 = "http://hotfix.oos.xk12.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fhotfix.wopi.xk12.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_VYHS5tb14I.ppt&action=embedview&sc=032105722547&token=c31a7b9d3f124cb097e642626dabf600&system_id=61951185794&md5=rw_VYHS5tb14I.ppt&isokaypad=1";

//    String url = "http://oos.okjiaoyu.cn/p/PowerPointFrame.aspx?WOPISrc=http%3A%2F%2Fwopi.okjiaoyu.cn%2Fwopi%2Ffiles%2Fhttp%3A%2F%2Frw.okjiaoyu.cn%2Frw_W0nKnxXHNu.ppt&action=embedview&sc=030295951894&system_id=61951185794&token=a6d973fba95d4befaf0219f27df1f24f&md5=rw_W0nKnxXHNu.ppt&isokaypad=1";
//      String url = "https://owa.okjiaoyu.cn/x/_layouts/mobile/mXL.aspx?ui=en%2DUS&rs=en%2DUS&WOPISrc=https%3A%2F%2Fowa%2Eokjiaoyu%2Ecn%2Foh%2Fwopi%2Ffiles%2F%40%2FwFileId%3FwFileId%3Dhttps%253A%252F%252Frc%252Eokjiaoyu%252Ecn%252Frc%255FFOi6r3t5mM%252Exls&access_token=1&" +
//        "access_token_ttl=0&wdMobileHost=2";

    private static final String url_ppt = "https://jiaoshi.qa-hotfix.xk12.cn/resource_vm/res_detail?rid=2493035&type=1";
    private static final String url_pdf = "";
    private static final String url_doc = "";
    private static final String url_excel = "";
    private static final String url_mp4 = "https://rv.okjiaoyu.cn/rv_14q4X1oJOes.low.h264.mp4";

    private WebView webView;

    /** 视频全屏参数 */
    protected static final FrameLayout.LayoutParams COVER_SCREEN_PARAMS = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    private View customView;
    private FrameLayout fullscreenContainer;
    private WebChromeClient.CustomViewCallback customViewCallback;

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

        settings.setJavaScriptEnabled(true);// 设置支持javascript脚本
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);//设置webview缓存模式
        mWebview.setVerticalScrollBarEnabled(false); // 取消Vertical ScrollBar显示
        mWebview.setHorizontalScrollBarEnabled(false); // 取消Horizontal ScrollBar显示
        //设置自适应屏幕，两者合用
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);

        settings.setAllowFileAccess(true);// 允许访问文件
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
        mWebview.setFocusable(false); // 去掉超链接的外边框
        settings.setDefaultTextEncodingName("GBK");//设置文本编码（根据页面要求设置： utf-8）
//        mWebview.setWebChromeClient(new MyWebChromeClient());
        mWebview.setWebChromeClient(webChromeClient);

        mWebview.loadUrl(url_mp4);

        /**

         一般很少会用到这个，用WebView组件显示普通网页时一般会出现横向滚动条，这样会导致页面查看起来非常不方便。LayoutAlgorithm是一个枚举，用来控制html的布局，总共有三种类型：
         NORMAL：正常显示，没有渲染变化。
         SINGLE_COLUMN：把所有内容放到WebView组件等宽的一列中。
         NARROW_COLUMNS：可能的话，使所有列的宽度不超过屏幕宽度。
         *
         */
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);

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

    private class MyWebChromeClient extends WebChromeClient {

        // 全屏的时候调用
        @Override
        public void onShowCustomView(View view, CustomViewCallback callback) {

            super.onShowCustomView(view, callback);

        }

        // 切换为竖屏的时候调用
        @Override
        public void onHideCustomView() {

            super.onHideCustomView();

        }
    }




}
