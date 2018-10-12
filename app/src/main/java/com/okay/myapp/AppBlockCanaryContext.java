package com.okay.myapp;

import com.github.moduth.blockcanary.BlockCanaryContext;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/10/11 17:24
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class AppBlockCanaryContext extends BlockCanaryContext {


    @Override
    public String provideQualifier() {
        return "com.okay.myapp";
    }

    @Override
    public String provideNetworkType() {
        return "wifi";
    }

    @Override
    public int provideBlockThreshold() {
        return 500;
    }

    @Override
    public String providePath() {
        return "/blockcanary/log";
    }
}

