package com.okay.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_share_data)
    Button btn_share_data;
    @BindView(R.id.btn_send_binary_content)
    Button btnSendBinaryContent;
    @BindView(R.id.btn_scrollbarstyle)
    Button btnScrollbarstyle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_share_data,
            R.id.btn_send_binary_content,
            R.id.btn_scrollbarstyle
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_share_data:
                toOtherActivity(Activity01_ShareData.class);
                break;
            case R.id.btn_send_binary_content:
                toOtherActivity(Activity02_Multimedia.class);
                break;

            case R.id.btn_scrollbarstyle:
                toOtherActivity(Activity03_ScrollBarStyle.class);
                break;
        }
    }
}
