package com.xy.my_retrofit_rxjava2;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetWorkManager {

    private static final String TAG = "NetWorkManager";

    private static NetWorkManager mInstance;
    private static Retrofit mRetrofit;
    private static volatile Request request;

    private NetWorkManager(){}
    //单例获取NetWorkManager对象
    public static NetWorkManager getInstance(){
        if (mInstance == null){
            synchronized (NetWorkManager.class){
                if (mInstance == null){
                    mInstance = new NetWorkManager();
                }
            }
        }
        return mInstance;
    }


    //初始化OkHttpClient 和 Retrofit
    public void init(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build();

        mRetrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Request.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public Request getRequest(){

        if (request == null){
            synchronized (Request.class){
                request = mRetrofit.create(Request.class);
            }
        }
        return request;
    }


}
