package com.xy.retrofit.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2018/5/14.
 */
public class RetrofitManager {
    private Retrofit mRetrofit;
    private static OkHttpClient mOkHttpClient;
    public static RetrofitManager getInstance(){
        return new RetrofitManager();
    }
    private RetrofitManager(){

        if (null==mRetrofit) {
            if (null == mOkHttpClient) {
                mOkHttpClient = OkHttpUtil.getOkHttpClient();
            }
            //Retrofit2后使用build设计模式
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(AppConfig.API_SERVER)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(mOkHttpClient)
                    .build();


        }
    }

    public ApiService getApiService(){
        ApiService homeService = mRetrofit.create(ApiService.class);
        return homeService;
    }
}
