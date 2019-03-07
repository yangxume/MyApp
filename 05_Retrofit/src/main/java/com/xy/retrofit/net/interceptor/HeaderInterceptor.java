package com.xy.retrofit.net.interceptor;



import java.io.IOException;
import java.text.SimpleDateFormat;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 通用头部参数
 */
public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Request originalRequest = chain.request();

        Request.Builder requestBuilder = originalRequest.newBuilder()
                .header("Api-Gzip", "0")
                //requestid为统一uuid hash正值变为数字后，拿0补齐为10位，再加两位服务名
                .header("requestid", RequestIdGenerator.newRequestId())
                //Request-From 自定义header来区分请求来源
                .header("Request-From", "t_classroom")
                .method(originalRequest.method(), originalRequest.body())
                .url(originalRequest.url());

        Request request = requestBuilder.build();

        return chain.proceed(request);
    }
}
