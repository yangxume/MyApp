package com.okay.myapp.v4;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.PermissionChecker;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/20 14:42
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
             提供一系列核心的工具类，
             如 AsyncTaskLoader 和 PermissionChecker，大小为 90k
             'com.android.support:support-core-utils:24.2.1'
 * <p>
 * Update records:
 */

public class ActivitySupportCoreUtils extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int permissionDenied = PermissionChecker.PERMISSION_DENIED;
    }


    class MyLoadTasker extends AsyncTaskLoader<Void> {


        public MyLoadTasker(Context context) {
            super(context);
        }

        @Override
        public Void loadInBackground() {
            return null;
        }
    }

}
