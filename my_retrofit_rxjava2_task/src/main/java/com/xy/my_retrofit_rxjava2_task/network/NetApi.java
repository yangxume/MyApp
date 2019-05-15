package com.xy.my_retrofit_rxjava2_task.network;

import android.util.Log;


import com.xy.my_retrofit_rxjava2_task.utils.LogUtils;
import com.xy.my_retrofit_rxjava2_task.network.model.request.RequestIdGenerator;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * desc:NetApi
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */
public class NetApi {
    private static String TAG = "t_net_task";
    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;
    private static Hashtable<String, NetApi> sNetApiTable = new Hashtable<>();
    private static Hashtable<String, Retrofit> sRetrofitTable = new Hashtable<>();

    private NetApi(String baseUrl) {
        initRetrofit(baseUrl);
    }

    public static NetApi getInstance(String baseUrl) {
        NetApi instance = sNetApiTable.get(baseUrl);
        sRetrofit = sRetrofitTable.get(baseUrl);
        if (instance == null) {
            synchronized (NetApi.class) {
                if (instance == null) {
                    instance = new NetApi(baseUrl);
                    sNetApiTable.put(baseUrl, instance);
                }
            }
        }
        if (sRetrofit == null) {
            initRetrofit(baseUrl);
        }
        return instance;
    }

    public static void init(String baseUrl, OkHttpClient httpClient) {
        if (httpClient == null) {
            initOkHttpClient();
        } else {
            sOkHttpClient = httpClient;
        }
        getInstance(baseUrl);
    }

    public static OkHttpClient getOkHttpClient() {
        if (sOkHttpClient == null) {
            initOkHttpClient();
        }
        return sOkHttpClient;
    }

    /**
     * 初始化retrofit
     *
     * @param baseUrl url
     */
    private static void initRetrofit(String baseUrl) {
        sRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sRetrofitTable.put(baseUrl, sRetrofit);

    }

    /**
     * 初始化httpClient
     */
    private static void initOkHttpClient() {
        if (sOkHttpClient == null) {
            synchronized (NetApi.class) {
                if (sOkHttpClient == null) {
                    OkHttpClient.Builder build = new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request.Builder builder = chain.request().newBuilder();
                                    builder.header("requestid", RequestIdGenerator.newRequestId())
//                                            .header("appversion", Device.getVersionName())
                                            .header("Api-Gzip", "0")
                                            //Request-From 自定义header来区分请求来源
                                            .header("Request-From", "t_task");
                                    Request request = builder.build();
                                    return chain.proceed(request);
                                }
                            })
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS);
                    if(true) {
                        build.addInterceptor(xLogInterceptor);//xLog 写文件需要时间
                    }
                    sOkHttpClient = build.build();
                }
            }
        }
    }

    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static Interceptor xLogInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {

            long st = System.currentTimeMillis();
            final Request request = chain.request();
            RequestBody requestBody = request.body();
            boolean hasRequestBody = requestBody != null;
            String requestId = request.headers().get("requestid");
            LogUtils.d(TAG,"上行: requestId:"+requestId+",url="+request.url().toString());
            if(hasRequestBody) {
                Buffer buffer = new Buffer();
                requestBody.writeTo(buffer);

                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }

                if (isPlaintext(buffer)) {

                    LogUtils.d(TAG,"上行: requestId:"+requestId+",content="+buffer.readString(charset));
                }
            }
            Response response = chain.proceed(request);
            LogUtils.d(TAG,"下行: requestId:"+requestId+",http code="+response.code());

            if(HttpHeaders.hasBody(response)){
                ResponseBody responseBody = response.body();
                BufferedSource source = responseBody.source();
                source.request(Long.MAX_VALUE); // Buffer the entire body.
                Buffer buffer = source.buffer();

                Charset charset = UTF8;
                MediaType contentType = responseBody.contentType();
                if (contentType != null) {
                    charset = contentType.charset(UTF8);
                }

                if(isPlaintext(buffer)){
                    long contentLength = responseBody.contentLength();
                    if (contentLength != 0) {
                        LogUtils.d(TAG,"下行: requestId:"+requestId+",body="+buffer.clone().readString(charset));
                    }

                }

            }
            long et = System.currentTimeMillis();
            Log.i(TAG,"xlog time(ms)="+(et-st));
            return response;
        }
    };

    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    /**
     * 自定义httpClient
     *
     * @param httpClient httpClient
     */
    public void setOkHttpClient(OkHttpClient httpClient) {
        sOkHttpClient = httpClient;
    }

    /**
     * 获取retrofit对象
     *
     * @return retrofit
     */
    public Retrofit getRetrofit() {
        return sRetrofit;
    }
}
