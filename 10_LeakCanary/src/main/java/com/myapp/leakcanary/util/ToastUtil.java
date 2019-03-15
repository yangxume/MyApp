package com.myapp.leakcanary.util;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

public class ToastUtil {

    /**
     * 根据内容长度 选择 Toast.LENGTH_SHORT 、Toast.LENGTH_LONG
     *
     * @param context
     * @param message
     */
    public static void showByMessage(Context context, CharSequence message) {
        if (TextUtils.isEmpty(message))
            return;
        if (message.length() >= 10) {
            showLong(context, message);
        }else{
            showShort(context, message);
        }
    }

    /**
     * 根据内容长度 选择 Toast.LENGTH_SHORT 、Toast.LENGTH_LONG
     *
     * @param context
     * @param message
     */
    public static void showByMessage(Context context, int message) {
        showByMessage(context,context.getResources().getText(message));
    }

    /**
     * 短时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showShort(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 长时间显示Toast
     *
     * @param context
     * @param message
     */
    public static void showLong(Context context, CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

}
