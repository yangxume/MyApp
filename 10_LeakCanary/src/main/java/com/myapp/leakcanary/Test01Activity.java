package com.myapp.leakcanary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Test01Activity extends AppCompatActivity {

    private static final String TAG = "Test01Activity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test01);
    }

    @Override
    protected void onResume() {
        super.onResume();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    int i = 0;
                    i++;
                }
            }
        }).start();
        Log.i(TAG,"onResume......");
    }
}
