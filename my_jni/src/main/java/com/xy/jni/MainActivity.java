package com.xy.jni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

//    static {
//        System.loadLibrary("MyScriptEngine");
//        System.loadLibrary("MyScriptInk");
//        System.loadLibrary("MyScriptShape");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String libraryDirs = System.getProperty("java.library.path");
        Log.d("tag",libraryDirs);



    }

}
