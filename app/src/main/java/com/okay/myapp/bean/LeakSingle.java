package com.okay.myapp.bean;

import android.content.Context;
import android.widget.TextView;

import com.okay.myapp.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/10/11 16:20
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class LeakSingle {

    private static LeakSingle mInstance;

    private Context mContext;

    private TextView mTv;

    private LeakSingle(Context ctx){
        mContext = ctx;
    }

    public static LeakSingle getInstance(Context ctx){

        if (mInstance == null){
            mInstance = new LeakSingle(ctx);
        }
        return mInstance;
    }

    public  void setRetainedTextView(TextView tv){

        mTv = tv;
        mTv.setText(mContext.getString(R.string.app_name));

    }

}
