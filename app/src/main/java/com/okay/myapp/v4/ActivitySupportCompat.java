package com.okay.myapp.v4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.okay.myapp.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/20 14:39
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
              com.android.support:support-compat:24.2.1
              兼容一些 Framework API，
              如 Context.getDrawable() 和View.performAccessibilityAction()，大小为 602k

 * <p>
 * Update records:
 */

public class ActivitySupportCompat extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ContextCompat.getDrawable(ActivitySupportCompat.this, R.mipmap.ic_launcher);

    }
}
