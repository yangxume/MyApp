package com.xy.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xy.retrofit.bean.LoginBean;
import com.xy.retrofit.net.NetUtils;

import org.json.JSONException;
import org.json.JSONObject;


import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * https://www.jianshu.com/p/b5546905ccbc
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btn1:
                login("admin","admin");
                break;

        }

    }


    public void login(String username, String pwd) {

        JSONObject params = new JSONObject();
        try {
            params.put("username", username);
            params.put("password", pwd);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                params.toString());
        NetUtils.getInstance().getLogin(new retrofit2.Callback<LoginBean>() {
            @Override
            public void onResponse(retrofit2.Call<LoginBean> call, retrofit2.Response<LoginBean> response) {

            }

            @Override
            public void onFailure(retrofit2.Call<LoginBean> call, Throwable t) {

            }
        }, requestBody);
    }
}
