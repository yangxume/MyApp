package com.xy.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * https://blog.csdn.net/fightingXia/article/details/70947701
 */
public class MainActivity extends AppCompatActivity {

    private String url = "https://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testRequestSync() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    //1.创建OkHttpClicent 对象

                    OkHttpClient okHttpClient = new OkHttpClient();

                    //2.创建Request对象
                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    //3.获取Response对象
                    Response response = okHttpClient.newCall(request).execute();

                    if (response.isSuccessful()){

                        ResponseBody body = response.body();
                        int code = response.code();
                        String message = response.message();


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }
}
