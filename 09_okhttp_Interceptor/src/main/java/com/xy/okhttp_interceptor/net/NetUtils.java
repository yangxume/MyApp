package com.xy.okhttp_interceptor.net;

import android.util.Log;

import com.google.gson.JsonObject;
import com.xy.okhttp_interceptor.net.base.RetrofitClient;
import com.xy.okhttp_interceptor.net.result.BaseObserver;
import com.xy.okhttp_interceptor.net.result.RxResultHelper;


public class NetUtils {

    public static void login(String username, String password) {

        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("username", username);
        jsonObject.addProperty("password", password);

        RetrofitClient.getInstance()
                .create(ApiService.class)
                .login(jsonObject)
                .compose(RxResultHelper.<JsonObject>handleResult())
                .subscribe(new BaseObserver<JsonObject>() {
                    @Override
                    public void next(JsonObject value) {

                        Log.e( "\tnext", "error:\t" + value);

                    }

                    @Override
                    public void error(ErrorMsg msg) {

                        Log.e( "\terror", "error:\t" + msg);


                    }

                    @Override
                    public void complete() {
                    }
                });
    }
}
