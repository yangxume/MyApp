package com.xy.fresco;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Context ctx;
    private String imageUrl = "http://newsimg.5054399.com/uploads/userup/1306/011035145434.jpg";

    private SimpleDraweeView simpleDraweeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();

    }

    private void initView() {

        simpleDraweeView = findViewById(R.id.simpleDraweeView);

    }

    private void initData() {
        ctx = MainActivity.this;
    }

    public void frescoBaseUse(View view){

        Uri uri = Uri.parse(imageUrl);
        simpleDraweeView.setImageURI(uri);

    }
}
