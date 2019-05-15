package com.xy.my_retrofit_rxjava2;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;

public interface Request {

    public static final String BASE_URL = "https://www.wanandroid.com";

    Call<ResponseBody> login();

    Observable<ResponseBody> logout();
}
