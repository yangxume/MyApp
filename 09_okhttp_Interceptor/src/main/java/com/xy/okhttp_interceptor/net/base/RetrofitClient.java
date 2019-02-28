package com.xy.okhttp_interceptor.net.base;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.xy.okhttp_interceptor.AppConstant;
import com.xy.okhttp_interceptor.interceptor.HeaderInterceptor;
import com.xy.okhttp_interceptor.interceptor.HttpLoggingInterceptor;
import com.xy.okhttp_interceptor.net.base.convert.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.Dns;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 */
public class RetrofitClient {

    private Retrofit mRetrofit;
    private String baseUrl = AppConstant.BASE_URL;

    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }

    public static RetrofitClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static RetrofitClient getInstance(Dns dns){
        return new RetrofitClient(dns);
    }

    private RetrofitClient() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getDefaultOkHttpClient(null))
                .build();
    }

    private RetrofitClient(Dns dns) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        mRetrofit = new Retrofit
                .Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getDefaultOkHttpClient(dns))
                .build();
    }

    @NonNull
    public OkHttpClient getDefaultOkHttpClient(Dns dns){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder()
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                //连接超时
                .connectTimeout(10, TimeUnit.SECONDS)
                //读取超时
                .readTimeout(30, TimeUnit.SECONDS)
                //写入超时
                .writeTimeout(10, TimeUnit.SECONDS)
                //stetho,可以在chrome中查看请求
                //.addNetworkInterceptor(new StethoInterceptor())
                //失败重连
                .retryOnConnectionFailure(true);
//                //添加ssl验证
//                .hostnameVerifier(SSLSocketFactory.getHostnameVerifier())
//                .sslSocketFactory(SSLSocketFactory.getSSLContext().getSocketFactory());

        if(dns == null){
            return builder.build();
        }

        return builder.dns(dns).build();
    }

    public  <T> T create(final Class<T> service) {
        if (service == null) {
            throw new RuntimeException("Api service is null!");
        }
        return mRetrofit.create(service);
    }
}
