package com.myapp.leakcanary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class Test04_Thread extends AppCompatActivity {

    private static final String TAG = "Test04_Thread";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test04_thread);
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
