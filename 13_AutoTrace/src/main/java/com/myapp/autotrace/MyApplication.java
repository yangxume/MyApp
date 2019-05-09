package com.myapp.autotrace;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.Window;

import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    // debug 模式的数据接收地址 （测试，测试项目）
    final static String SA_SERVER_URL_DEBUG = "【测试项目】数据接收地址";

    // release 模式的数据接收地址（发版，正式项目）
    final static String SA_SERVER_URL_RELEASE = "【正式项目】数据接收地址";

//    private ActivityLifecycleCallbacks activityLifecycleCallbacks;

    @Override
    public void onCreate() {
        super.onCreate();

        // 在 Application 的 onCreate 初始化 SDK
        initSensorsDataSDK(this);

//        activityLifecycleCallbacks = new ActivityLifecycleCallbacks() {
//            @Override
//            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
//
//                Window window = activity.getWindow();
//                Window.Callback callback = window.getCallback();
//
////                ViewTreeObserver.OnGlobalLayoutListener();
//
//
//            }
//
//            @Override
//            public void onActivityStarted(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityResumed(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityPaused(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivityStopped(Activity activity) {
//
//            }
//
//            @Override
//            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
//
//            }
//
//            @Override
//            public void onActivityDestroyed(Activity activity) {
//
//            }
//        };
//        registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
    }

    /**
     * 初始化 SDK 、设置公共属性、开启自动采集
     */
    private void initSensorsDataSDK(Context context) {
        try {
            // 初始化 SDK
            boolean isDebugMode;
            SensorsDataAPI.sharedInstance(
                    context,                                                                                  // 传入 Context
                    (isDebugMode = isDebugMode(context)) ? SA_SERVER_URL_DEBUG : SA_SERVER_URL_RELEASE      // 数据接收的 URL
            );

            // 初始化SDK后，获取应用名称设置为公共属性
            JSONObject properties = new JSONObject();
            properties.put("app_name", getAppName(context));
            SensorsDataAPI.sharedInstance().registerSuperProperties(properties);

            // 打开自动采集, 并指定追踪哪些 AutoTrack 事件
            List<SensorsDataAPI.AutoTrackEventType> eventTypeList = new ArrayList<>();
            // $AppStart
            eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_START);
            // $AppEnd
            eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_END);
            // $AppViewScreen
            eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN);
            // $AppClick
            eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_CLICK);
            SensorsDataAPI.sharedInstance().enableAutoTrack(eventTypeList);


            try {
                // 打开自动采集, 并指定追踪哪些 AutoTrack 事件
                List<SensorsDataAPI.AutoTrackEventType> eventTypeList = new ArrayList<>();
                // $AppStart
                eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_START);
                // $AppEnd
                eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_END);
                // $AppViewScreen
                eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN);
                // $AppClick
                eventTypeList.add(SensorsDataAPI.AutoTrackEventType.APP_CLICK);
                SensorsDataAPI.sharedInstance().enableAutoTrack(eventTypeList);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param context App 的 Context
     *                获取应用程序名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param context App 的 Context
     * @return debug return true,release return false
     * 用于判断是 debug 包，还是 relase 包
     */
    public static boolean isDebugMode(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
