package com.xy.okhttp_interceptor.net;

import com.google.gson.JsonObject;
import com.xy.okhttp_interceptor.net.result.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 */
public interface ApiService {


    @POST("login/json")
    Observable<HttpResult<JsonObject>> login(@Body JsonObject jsonObject);

//    @POST("login/json")
//    Call<LoginBean>  getLogin(@Body RequestBody body);
}
