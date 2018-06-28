package com.xy.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xy.retrofit.net.OkHttpInterceptor;
import com.xy.retrofit.service.NewsService;
import com.xy.retrofit.util.Constants;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * https://www.jianshu.com/p/b5546905ccbc
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button btnTestOkHttp;
    private Button btnTestOkHttpInterceptor;
    private Button btnTestRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnTestOkHttp = findViewById(R.id.btnTestOkHttp);
        btnTestOkHttpInterceptor = findViewById(R.id.btnTestOkHttpInterceptor);
        btnTestRetrofit = findViewById(R.id.btnTestRetrofit);

        btnTestOkHttp.setOnClickListener(this);
        btnTestOkHttpInterceptor.setOnClickListener(this);
        btnTestRetrofit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnTestOkHttp:
                testOkHttp(Constants.social);
                break;

            case R.id.btnTestOkHttpInterceptor:
                testOkHttpInterceptor(Constants.guonei);
                break;

            case R.id.btnTestRetrofit:
                testRetrofit();

                break;
        }

    }

    private void testOkHttp(String url) {

        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: " + e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "onResponse: ");

                if (response.isSuccessful()) {

                    Log.d(TAG, "onResponse: code = " + response.code());
                    Log.d(TAG, "onResponse: message = " + response.message());

                    ResponseBody responseBody = response.peekBody(1024 * 1024);
                    if (responseBody != null) {

                        String body = responseBody.string();
                        Log.d(TAG, "onResponse: body = " + body);

                    }

                }
            }
        });


    }

    private void testOkHttpInterceptor(String url) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new OkHttpInterceptor())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d(TAG, "onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.d(TAG, "onResponse: ");
                Log.d(TAG, "onResponse: code =  " + response.code());
                Log.d(TAG, "onResponse: message = " + response.message());

                ResponseBody responseBody = response.peekBody(1024 * 1024);
                if (responseBody != null) {
                    Log.d(TAG, "onResponse: body =  "+responseBody.string());
                }
            }
        });

    }

    private void testRetrofit(){

        String base_url = "http://www.fanhuanvshu.ltd/fh_nvshu_client/";

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new OkHttpInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsService newsService = retrofit.create(NewsService.class);
        retrofit2.Call<ResponseBody> call = newsService.queryPageForArticle();

        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    Log.d(TAG, "Retrofit onResponse: "+response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }

//    private void test2Retrofit(){
//
//        RetrofitClient.getInstance()
//                .create(NewsService.class)
//                .getGuonei()
//                .enqueue(new retrofit2.Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//
//                        Log.d(TAG, "onResponse: "+response.body().string());
//
//                    }
//
//                    @Override
//                    public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
//
//                    }
//                });
//
//
//
//    }

}
