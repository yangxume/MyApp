package com.xy.my_app_test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;

import java.net.InetAddress;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        thread.start();






    }

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {

            isYun(TestActivity.this);

        }
    });

    public static boolean isYun(Context context) {
        boolean mInternet;
        try {
            InetAddress ocb_address = InetAddress.getByName("ocb.okjiaoyu.cn");
            InetAddress ap_address = InetAddress.getByName("ap.okjiaoyu.cn");


            String ocb_hostAddress = ocb_address.getHostAddress();
            String ap_hostAddress = ap_address.getHostAddress();

            Log.d(TAG, "isYun: ocb_hostAddress = "+ocb_hostAddress);
            Log.d(TAG, "isYun: ap_hostAddress = "+ap_hostAddress);

            if (!TextUtils.isEmpty(ocb_hostAddress) && ocb_address.equals(ap_hostAddress)) {
                mInternet = true;
            } else {
                mInternet = false;
            }
        } catch (Exception e) {
            mInternet = false;
        }
        return mInternet;
    }
}
