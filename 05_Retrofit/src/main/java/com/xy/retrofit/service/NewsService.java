package com.xy.retrofit.service;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/6/13 16:41
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public interface NewsService {

    @GET("social/?key=5e7e112aedd1abce757f9903a219e214&num=10")
    Call<ResponseBody> getSocial();

    @GET("guonei/?key=5e7e112aedd1abce757f9903a219e214&num=10")
    Observable<ResponseBody> getGuonei();

    @GET("fhClientArticle/queryPageForArticle.do?&page=1&rows=10")
    Call<ResponseBody> queryPageForArticle();
}
