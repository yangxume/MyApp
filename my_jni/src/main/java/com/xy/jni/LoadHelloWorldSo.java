package com.xy.jni;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/2/6 16:50
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class LoadHelloWorldSo {

    static {
        System.loadLibrary("HelloWorld");
    }

}
