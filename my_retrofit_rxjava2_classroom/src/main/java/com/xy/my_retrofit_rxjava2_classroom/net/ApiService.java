package com.xy.my_retrofit_rxjava2_classroom.net;

import com.google.gson.JsonObject;
import com.xy.my_retrofit_rxjava2_classroom.net.base.result.HttpResult;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created on 17/3/14.
 * author: yuanbaoyu
 */
public interface ApiService {

    @GET
    Observable<JsonObject> getSokckTicket(@Url String url, @Query("token") String token);


    /**
     * 查询已发布课程
     *
     * @return
     */
    @POST("api/t_pad/res_package/pkg_list_pub")
    Observable<HttpResult<JsonObject>> queryCourses(@Body JsonObject jsonObject);


}
