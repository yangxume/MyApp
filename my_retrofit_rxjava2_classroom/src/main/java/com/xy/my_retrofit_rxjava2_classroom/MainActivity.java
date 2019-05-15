package com.xy.my_retrofit_rxjava2_classroom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xy.my_retrofit_rxjava2_classroom.net.NetUtils;
import com.xy.my_retrofit_rxjava2_classroom.net.constants.ParamConstant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String class_id = "0101";
        String page = "10";
        String token = "";
        String uid = "";
        String typePublish = "";

        NetUtils.queryCourses(class_id, page, token, uid, typePublish);

    }
}
