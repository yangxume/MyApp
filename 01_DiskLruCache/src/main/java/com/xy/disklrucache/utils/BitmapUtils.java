package com.xy.disklrucache.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.xy.disklrucache.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/5/29 14:38
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class BitmapUtils {

    private static final String TAG = "BitmapUtils";

    public static Bitmap decodeSampleBitmapFromResource(Resources resources, int resId, int reqW, int reqH){

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources,resId,options);
        options.inSampleSize = calculateInSampleSize(options,reqW,reqH);
        Log.d(TAG, "onCreate: options.inSampleSize = "+ options.inSampleSize);

        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeResource(resources, R.mipmap.image1,options);
    }


    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight){

        int outWidth = options.outWidth;
        int outHeight = options.outHeight;

        int inSampleSize = 1;

        if (outWidth > reqWidth || outHeight > reqHeight){

            int widthRatio = Math.round(outWidth / reqWidth);
            int heightRatio = Math.round(outHeight / reqHeight);

            inSampleSize = heightRatio < widthRatio ? heightRatio:widthRatio;
        }
        return inSampleSize;
    }


}
