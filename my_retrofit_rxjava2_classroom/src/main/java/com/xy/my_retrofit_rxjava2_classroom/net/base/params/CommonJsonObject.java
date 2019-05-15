package com.xy.my_retrofit_rxjava2_classroom.net.base.params;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;

import com.google.gson.JsonObject;

/**
 * 通用上行参数
 * <p>
 * Created on 17/3/14.
 * author: yuanbaoyu
 */
public class CommonJsonObject {


    public static JsonObject getCommonJsonObject() {

        JsonObject commonJson = null;

//        Context context = ApplicationStore.get().getApplicationContext();
//        DisplayMetrics dm = context.getResources().getDisplayMetrics();
//
//        String vs = Device.getVersionName();//((Build.VERSION.RELEASE == null || Build.VERSION.RELEASE.length() == 0) ? "" : Build.VERSION.RELEASE);
//        String ua = Build.DISPLAY;
//
//        ConnectManager e = new ConnectManager(context);

        String serial = ((Build.SERIAL == null) ? "" : Build.SERIAL);

        commonJson = new JsonObject();

//        commonJson.addProperty(JsonConstants.JSON_VS, vs);
//        commonJson.addProperty(JsonConstants.JSON_VC, Device.getVersionCode() + "");
//        commonJson.addProperty(JsonConstants.JSON_OS, "Android");
//
//        commonJson.addProperty(JsonConstants.JSON_UA, ua);
//        commonJson.addProperty(JsonConstants.JSON_SW, String.valueOf(dm.widthPixels));
//        commonJson.addProperty(JsonConstants.JSON_SH, String.valueOf(dm.heightPixels));
//
//
//        commonJson.addProperty(JsonConstants.JSON_CONTYPE, Integer.valueOf(e.getConnectionString(context)));
//        commonJson.addProperty(JsonConstants.JSON_IMEI, Device.getIMEI(context));
//        commonJson.addProperty(JsonConstants.JSON_MAC, Device.getLocalMacAddress(context));
//
//        commonJson.addProperty(JsonConstants.JSON_CHANNEL, Config.CHANNEL);
//        commonJson.addProperty(JsonConstants.JSON_UDID, Device.getUdid());
//        commonJson.addProperty(JsonConstants.JSON_SERIAL, serial);
//        commonJson.addProperty(JsonConstants.JSON_ICCID, Device.getIccId());

        return commonJson;
    }
}
