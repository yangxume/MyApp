package com.xy.okhttp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * https://blog.csdn.net/fightingXia/article/details/70947701
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button btn_okhttp_get_sync;
    private TextView tv_okhttp_get_sync;

    private Button btn_okhttp_get_async;
    private TextView tv_okhttp_get_async;

    private Button btn_okhttp_post_async;
    private TextView tv_okhttp_post_async;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        btn_okhttp_get_sync = findViewById(R.id.btn_okhttp_get_sync);
        tv_okhttp_get_sync = findViewById(R.id.tv_okhttp_get_sync);

        btn_okhttp_get_async = findViewById(R.id.btn_okhttp_get_async);
        tv_okhttp_get_async = findViewById(R.id.tv_okhttp_get_async);

        btn_okhttp_post_async = findViewById(R.id.btn_okhttp_post_async);
        tv_okhttp_post_async = findViewById(R.id.tv_okhttp_post_async);

        btn_okhttp_get_sync.setOnClickListener(this);
        btn_okhttp_get_async.setOnClickListener(this);
        btn_okhttp_post_async.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn_okhttp_get_sync:
                getDataSync("https://github.com/hongyangAndroid");
                break;
            case R.id.btn_okhttp_get_async:
                getDataAsync("https://github.com/hongyangAndroid");
                break;
            case R.id.btn_okhttp_post_async:
                postDataAsync("https://www.douban.com/accounts/login?source=book");
                break;
        }

    }

    private static final int OKHTTP_GET_SYNC_MSG = 0;
    private static final int OKHTTP_GET_ASYNC_MSG = 1;
    private static final int OKHTTP_POST_SYNC_MSG = 2;
    private static final int OKHTTP_POST_ASYNC_MSG = 3;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {

                case OKHTTP_GET_SYNC_MSG:

                    String text_sync_msg = (String) msg.obj;
                    tv_okhttp_get_sync.setText(text_sync_msg);

                    break;

                case OKHTTP_GET_ASYNC_MSG:

                    String response_get_async = (String) msg.obj;
                    tv_okhttp_get_async.setText(response_get_async);

                    break;

                case OKHTTP_POST_SYNC_MSG:


                    break;

                case OKHTTP_POST_ASYNC_MSG:

                    String response_post_async = (String) msg.obj;
                    tv_okhttp_post_async.setText(response_post_async);

                    break;

            }

        }
    };


    public void getDataSync(final String url) {

        Log.d(TAG, " onResponse: getDatasync current-thread-name1 = " + Thread.currentThread().getName());

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

                    //回调的方法在子线程
                    Log.d(TAG, "onResponse: getDatasync current-thread-name2 = " + Thread.currentThread().getName());
                    if (response.isSuccessful()) {

                        Log.d(TAG, "onResponse: 获取数据成功了...");
                        Log.d(TAG, "onResponse: response.code() = " + response.code());
                        Log.d(TAG, "onResponse: response.message() = " + response.message());
//                        Log.d(TAG, "onResponse: response.body() = "+response.body().string());

                        ResponseBody responseBody = response.peekBody(1024 * 1024);
                        String body = null;
                        if (responseBody != null) {
                            body = responseBody.string();
                            Log.d(TAG, "onResponse: body = " + body);
                        }

                        Message message = mHandler.obtainMessage();
                        message.what = OKHTTP_GET_SYNC_MSG;
                        message.obj = response.message();
                        mHandler.sendMessage(message);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();


    }

    public void getDataAsync(String url) {

        Log.d(TAG, "onResponse: getAsync current-thread-name1 = " + Thread.currentThread().getName());

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //回调的方法在子线程
                Log.d(TAG, "onResponse: current-thread-name2 = " + Thread.currentThread().getName());
                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: 获取数据成功了...");
                    Log.d(TAG, "onResponse: response.code() = " + response.code());
                    Log.d(TAG, "onResponse: response.message() = " + response.message());
//                    Log.d(TAG, "onResponse: response.body() = " + response.body().toString());

                    ResponseBody responseBody = response.peekBody(1024 * 1024);
                    String body = null;
                    if (responseBody != null) {
                        body = responseBody.string();
                    }

                    Message message = mHandler.obtainMessage();
                    message.what = OKHTTP_GET_ASYNC_MSG;
                    message.obj = response.message();
                    mHandler.sendMessage(message);

                }
            }
        });


    }

    public void postDataAsync(String url) {

        Log.d(TAG, "onResponse: postDataAsync current-thread-name1 = " + Thread.currentThread().getName());

        /**
         * 1. Post req
         *    param: FormBody
         */
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("username", "zhangsan");

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .post(formBody.build())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //回调的方法在子线程
                Log.d(TAG, "onResponse: postDataAsync current-thread-name2 = " + Thread.currentThread().getName());
                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: 获取数据成功了...");
                    Log.d(TAG, "onResponse: response.code() = " + response.code());
                    Log.d(TAG, "onResponse: response.message() = " + response.message());
//                    Log.d(TAG, "onResponse: response.body() = " + response.body().toString());

                    ResponseBody responseBody = response.peekBody(1024 * 1024);
                    String body = null;
                    if (responseBody != null) {
                        body = responseBody.string();
                    }

                    Message message = mHandler.obtainMessage();
                    message.what = OKHTTP_POST_ASYNC_MSG;
                    message.obj = response.message();
                    mHandler.sendMessage(message);

                }

            }
        });


        /**
         * 2. Post req
         *    param: RequestBody
         */
        String jsonStr = "{\"username\":\"lisi\",\"nickname\":\"李四\"}";//json数据.

        MediaType mediaType = MediaType.parse("application/json;charset=utf-8");

        RequestBody body = RequestBody.create(mediaType, jsonStr);

        Request request2 = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }


    public void okHttpInterceptor() {


        Interceptor appInterceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();
                HttpUrl httpUrl = request.url();
                String url = httpUrl.url().toString();

                Log.d(TAG, "appInterceptor: url = " + url);
                Log.d(TAG, "appInterceptor begin ");

                Response response = chain.proceed(request);

                Log.d(TAG, "appInterceptor end ");
                Log.d(TAG, "appInterceptor: body = " + response.body().toString());

                return response;
            }
        };

        Interceptor netInterceptor = new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {

                Request request = chain.request();

                Log.d(TAG, "netIntercept begin");

                Response response = chain.proceed(request);

                Log.d(TAG, "netIntercept end");

                return response;
            }
        };


        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .build();


        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });


    }


}
