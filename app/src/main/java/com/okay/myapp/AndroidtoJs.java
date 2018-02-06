package com.okay.myapp;

import android.webkit.JavascriptInterface;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/1 14:29
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class AndroidtoJs extends Object {

    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public void sendResExceptionMsg() {
        System.out.println("JS调用了Android的sendResExceptionMsg方法");
    }
}
