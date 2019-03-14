package com.xy.leakcanary;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_canary01_getsystemserview)
    Button btnCanaryGetsystemserview;
    @BindView(R.id.btn_canary02)
    Button btnCanary2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    private static PowerManager powerManager;

    private void canary01GetSystemService() {
        //getSystemService内存泄漏
        powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
    }


    @OnClick({
            R.id.btn_canary01_getsystemserview,
            R.id.btn_canary02
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_canary01_getsystemserview:
                canary01GetSystemService();
                break;
            case R.id.btn_canary02:
                break;
        }
    }
}
