package com.xy.retrofit.net;

import android.util.Log;

import com.xy.retrofit.util.NetWorkUtils;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/6/6 17:58
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class OkHttpInterceptor implements Interceptor {

    private static final String TAG = OkHttpInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        Log.d(TAG, "intercept: req-url = "+request.url());
        Log.d(TAG, "intercept: chain-conn = "+chain.connection());
        Log.d(TAG, "intercept: req-headers = "+request.headers());

        if (!NetWorkUtils.isConnected()){
            request.newBuilder().cacheControl(CacheControl.FORCE_CACHE);
        }

        Response response = chain.proceed(request);

        ResponseBody responseBody = response.peekBody(1024 * 1024);
        if (responseBody != null){

            Log.d(TAG, "intercept: response-body"+responseBody.string());

        }

        return response;
    }
}
