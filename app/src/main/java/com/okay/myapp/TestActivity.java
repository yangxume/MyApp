package com.okay.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/9/17 18:16
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String testStr = "\"answer\": null";

        JSONObject jsonObject = null;
        try {

            jsonObject = new JSONObject(testStr);

            String str = jsonObject.optString("answer","");

            Log.e("test", str);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
