package com.xy.retrofit.net;

import com.xy.retrofit.MyApplication;
import com.xy.retrofit.util.Config;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/6/7 11:21
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class RetrofitClient {

    private static OkHttpClient okHttpClient ;
    private static Cache cache = new Cache(MyApplication.getContext().getCacheDir(),1024*1024*10);


    private static RetrofitClient instance;
    private final Retrofit retrofit;

    public static RetrofitClient getInstance(){
        if (instance == null){
            synchronized (RetrofitClient.class){
                instance = new RetrofitClient();
            }
        }
        return instance;
    }

    private RetrofitClient(){

        retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public <T> T create(Class<T> service){

         return retrofit.create(service);
    }

    private OkHttpClient getOkHttpClient(){
        if (okHttpClient == null){
            synchronized (RetrofitClient.class){
                if (okHttpClient == null){
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new OkHttpInterceptor())
                            .connectTimeout(60, TimeUnit.SECONDS)
                            .readTimeout(10,TimeUnit.SECONDS)
                            .writeTimeout(10,TimeUnit.SECONDS)
                            .cache(cache)
                            .build();
                }
            }
        }
        return okHttpClient;
    }



}
