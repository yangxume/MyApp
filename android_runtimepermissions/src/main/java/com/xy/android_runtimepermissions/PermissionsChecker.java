package com.xy.android_runtimepermissions;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class PermissionsChecker {

    private final Context mCtx;

    public PermissionsChecker(Context mCtx) {
        this.mCtx = mCtx.getApplicationContext();
    }

    public boolean lacksPermissions(String ... permissions){

        for (String permission : permissions){

            Log.d("tag",permission.toString());

            if (lackPermission(permission)){
                return true;
            }
        }

        return false;
    }

    private boolean lackPermission(String permission){

        return ActivityCompat.checkSelfPermission(mCtx,permission)
                == PackageManager.PERMISSION_GRANTED;
    }
}
