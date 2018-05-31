package com.xy.glide;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {

        imageView = findViewById(R.id.image_view);
    }

    public void loadImage(View view) {
        String url = "http://cn.bing.com/az/hprichbg/rb/Dongdaemun_ZH-CN10736487148_1920x1080.jpg";
        Glide.with(this)
                .load(url)
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.mipmap.ic_launcher)
                .into(imageView);
    }

    public void loadLocalImage(View view) {
        // 加载本地图片
        File file = new File(getExternalCacheDir() + "/image.jpg");
        Glide.with(this).load(file).into(imageView);

    }

    public void loadImageResource(View view) {

        // 加载应用资源
        int resource = R.mipmap.image1;
        Glide.with(this).
                load(resource).
                into(imageView);
    }

    public void loadImageBytes(View view) {
        // 加载二进制流
        byte[] image = getImageBytes();
        Glide.with(this).
                load(image).
                into(imageView);
    }

    private byte[] getImageBytes() {
        return new byte[0];
    }

    public void loadImageUri(View view) {

        // 加载Uri对象
        Uri imageUri = getImageUri();
        Glide.with(this).
                load(imageUri).
                into(imageView);
    }

    private Uri getImageUri() {



        return null;

    }
}
