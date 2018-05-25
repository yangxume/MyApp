package com.xy.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/3/19 17:42
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_frame_animation)
    Button btnFrameAnimation;
    @BindView(R.id.btn_tween_animation_rotate)
    Button btnTweenAnimationRotate;
    @BindView(R.id.btn_t_classroom_demo)
    Button btnTClassroomDemo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn_frame_animation,
            R.id.btn_tween_animation_rotate,
            R.id.btn_t_classroom_demo
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_frame_animation:
                startActivity(new Intent(this, Activity01_FrameAnimation.class));
                break;
            case R.id.btn_tween_animation_rotate:
                startActivity(new Intent(this, Activity02_Tween_Animation.class));
                break;
            case R.id.btn_t_classroom_demo:
//                startActivity(new Intent(this, ActivityTClassRoomDemo.class));
                break;
        }
    }
}
