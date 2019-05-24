package com.xy.t_luban;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;
import top.zibin.luban.CompressionPredicate;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;
import uk.co.senab.photoview.PhotoView;

import static android.media.MediaRecorder.VideoSource.CAMERA;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_take_photo)
    Button btnTakePhoto;
    @BindView(R.id.btn_open)
    Button btnOpen;
    @BindView(R.id.tv_yuan)
    TextView tvYuan;
    @BindView(R.id.tv_change)
    TextView tvChange;
    @BindView(R.id.iv_show_real)
    PhotoView ivShowReal;
    @BindView(R.id.iv_show_compress)
    PhotoView ivShowCompress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        testLuBan(null);
        initPersission();


    }

    private void initPersission() {
        String perm[] = {Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perm)) {

        } else {
            EasyPermissions.requestPermissions(this, "需要摄像头权限权限",
                    CAMERA, perm);
        }
    }

    private void testLuBan(File photo) {


        String path = photo.getPath();

        Luban.with(this)
                .load(photo)
                .ignoreBy(100)
                .setTargetDir(path)
                .filter(new CompressionPredicate() {
                    @Override
                    public boolean apply(String path) {
                        return !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif"));
                    }
                })
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {
                        // TODO 压缩开始前调用，可以在方法内启动 loading UI
                    }

                    @Override
                    public void onSuccess(File file) {
                        // TODO 压缩成功后调用，返回压缩后的图片文件
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO 当压缩过程出现问题时调用
                    }
                }).launch();
    }


    @OnClick({R.id.btn_take_photo, R.id.btn_open})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_take_photo:
                break;
            case R.id.btn_open:
                break;
        }
    }
}
