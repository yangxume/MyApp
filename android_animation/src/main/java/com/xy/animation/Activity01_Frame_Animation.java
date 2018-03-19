package com.xy.animation;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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
public class Activity01_Frame_Animation extends AppCompatActivity {

    private Context ctx;

    @butterknife.BindView(R.id.imageView)
    ImageView imageView;
    @butterknife.BindView(R.id.start)
    Button start;
    @butterknife.BindView(R.id.stop)
    Button stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = Activity01_Frame_Animation.this;
        setContentView(R.layout.activity01_frame_animation);
        butterknife.ButterKnife.bind(this);
    }

    @butterknife.OnClick({R.id.start, R.id.stop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.start:
                startFrameAnimation();
                break;
            case R.id.stop:
                stopFrameAnimation();
                break;
        }
    }

    private void stopFrameAnimation() {

        if (imageView != null) {
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
            if (animationDrawable != null)
                if (animationDrawable.isRunning())
                    animationDrawable.stop();
        }


    }

    private void startFrameAnimation() {

        AnimationDrawable animationDrawable = new AnimationDrawable();

        for (int i = 0; i < 24; i++) {
            int id;
            if (i < 10) {
                id = getResources().getIdentifier("img0" + i, "drawable", getPackageName());
            } else
                id = getResources().getIdentifier("img" + i, "drawable", getPackageName());

            Drawable drawable = ContextCompat.getDrawable(ctx, id);
            animationDrawable.addFrame(drawable, 200);
        }

        imageView.setBackground(animationDrawable);
        animationDrawable.setOneShot(false);

        AnimationDrawable animationDrawable1 = (AnimationDrawable) imageView.getBackground();
        animationDrawable1.start();

    }
}
