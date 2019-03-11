package com.xy.okhttp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttpUtil {

    private static final String TAG = "OkHttpUtil";

    public static void getRequest(String url) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                int code = response.code();
                System.out.println(TAG + "----test1: " + code);

                String message = response.message();
                System.out.println(TAG + "----test1: " + message);

                ResponseBody body = response.body();
                System.out.println(TAG + "----test1: " + body.string());
            } else {
                new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void postRequest(String url) {

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("username", "admin");
            jsonObject.put("password", "admin");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = FormBody.create(MediaType.parse("application/json"), jsonObject.toString());

        RequestBody postBody = null;

        Request request = new Request.Builder()
                .url(url)
                .post(postBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();
        try {
            Response response = okHttpClient.newCall(request).execute();

            System.out.println("code :"+response.code());
            System.out.println("message :"+response.message());
            System.out.println("response :"+response.body().string());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
