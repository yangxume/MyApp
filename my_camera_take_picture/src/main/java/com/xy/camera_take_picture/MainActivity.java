package com.xy.camera_take_picture;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.xy.camera_take_picture.UseIn_Activity.Activity_TakePhotoActivity;
import com.xy.camera_take_picture.UseIn_Fragment.Fragment_TakePhotoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Fragment使用
    public void btUseInFragment(View view) {
        startActivity(new Intent(this, Fragment_TakePhotoActivity.class));
    }

    //Activity使用
    public void btUseInActivity(View view) {
        startActivity(new Intent(this, Activity_TakePhotoActivity.class));
    }
}
