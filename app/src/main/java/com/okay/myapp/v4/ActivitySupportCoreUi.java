package com.okay.myapp.v4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.okay.myapp.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/20 14:48
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
             提供一系列核心的 UI，
             如 ViewPager、 NestedScrollView，大小为 240k
             'com.android.support:support-core-ui:24.2.1'
 * <p>
 * Update records:
 */

public class ActivitySupportCoreUi extends Activity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_core_ui);

    }

}
