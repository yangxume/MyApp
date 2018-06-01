package com.xy.fresco;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Fresco的应用：
 * 1、占位图
 * 2、进度图
 * 3、重试图
 * 4、失败图
 * 5、实际图
 * 6、缩放模式
 * 7、圆形图
 * 8、圆角图
 * 9、叠加图
 * 10、按压状态下叠加图
 * 11、背景图
 * 12、XML属性
 * 13、常见问题
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.btn_fresco_base_use)
    Button btnFrescoBaseUse;
    @BindView(R.id.sdv_fresco_base_use)
    SimpleDraweeView sdvFrescoBaseUse;

    @BindView(R.id.btn_fresco_round_circle)
    Button btnFrescoRoundCircle;
    @BindView(R.id.sdv_fresco_round_circle)
    SimpleDraweeView sdvFrescoRoundCircle;

    @BindView(R.id.btn_fresco_round_corner)
    Button btnFrescoRoundCorner;
    @BindView(R.id.sdv_fresco_round_corner)
    SimpleDraweeView sdvFrescoRoundCorner;

    private Context ctx;
    //    private String imageUrl = "http://newsimg.5054399.com/uploads/userup/1306/011035145434.jpg";
    private String imageUrl = "http://avatar.csdn.net/4/E/8/1_y1scp.jpg";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initData();

    }

    private void initData() {
        ctx = MainActivity.this;
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.btn_fresco_base_use,
            R.id.btn_fresco_round_circle,
            R.id.btn_fresco_round_corner
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fresco_base_use:
                frescoBaseUse();
                break;
            case R.id.btn_fresco_round_circle:
                frescoRoundCircle();
                break;
            case R.id.btn_fresco_round_corner:
                frescoRoundCorner();
                break;
        }
    }

    private void frescoRoundCorner() {

        Uri uri = Uri.parse(imageUrl);
        sdvFrescoRoundCorner.setImageURI(uri);

    }

    private void frescoRoundCircle() {

        Uri uri = Uri.parse(imageUrl);
        sdvFrescoRoundCircle.setImageURI(uri);


    }

    public void frescoBaseUse() {

        Uri uri = Uri.parse(imageUrl);
        sdvFrescoBaseUse.setImageURI(uri);

        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setOldController(sdvFrescoBaseUse.getController())
                .build();

        sdvFrescoBaseUse.setController(draweeController);
    }


    @OnClick(R.id.btn_fresco_round_corner)
    public void onViewClicked() {
    }
}
