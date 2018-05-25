package com.xy.animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 逐帧动画【Frame Animation】，即顺序播放事先做好的图像，跟电影类似
 * <p>
 * 也叫Drawable Animation动画，是最简单最直观动画类型
 * <p>
 * 逐帧动画XML资源文件方式
 * 这个是最常用的方式，在res/drawable目录下新建动画XML文件，如下所示
 * android:oneshot用来控制动画是否循环播放，true表示不会循环播放，false表示会循环播放
 * android:duration=”200”表示每一帧持续播放的时间
 */
public class Activity01_FrameAnimation extends AppCompatActivity {

    @BindView(R.id.btn_start)
    Button btnStart;
    @BindView(R.id.btn_stop)
    Button btnStop;
    @BindView(R.id.btn_raise_hand)
    Button btnRaiseHand;
    @BindView(R.id.btn_raise_hand_green_dot)
    Button btnRaiseHandGreenDot;
    private Context ctx;

    @BindView(R.id.imageView)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = Activity01_FrameAnimation.this;
        setContentView(R.layout.activity01_frame_animation);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_start,
            R.id.btn_stop,
            R.id.btn_raise_hand,
            R.id.btn_raise_hand_green_dot

    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                startFrameAnimation(R.drawable.anim01_frame_animation);
                break;

            case R.id.btn_raise_hand:
                startFrameAnimation(R.drawable.classroom_raise_hand_animlist);
                break;

            case R.id.btn_raise_hand_green_dot:
                startFrameAnimation(R.drawable.classroom_raise_hand_animlist_green_dot);
                break;

            case R.id.btn_stop:
                stopFrameAnimation();
                break;

        }
    }

    private void startFrameAnimation(int anim_drawable) {

        if (imageView == null) return;

        imageView.setImageResource(anim_drawable);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();

        if (animationDrawable == null) return;

        if (animationDrawable.isRunning()) return;

        animationDrawable.start();

    }

    private void stopFrameAnimation() {

        if (imageView == null) return;

        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        if (animationDrawable == null) return;

        if (!animationDrawable.isRunning()) return;

        animationDrawable.stop();

    }

}
