package com.okay.myapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/10/24 17:17
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity01_ShareData extends BaseActivity {

    private static final String TAG = Activity01_ShareData.class.getSimpleName();
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.btn_share_text)
    Button btnShareText;
    @BindView(R.id.btn_share_binary)
    Button btnShareBinary;
    @BindView(R.id.btn_share_multi_pieces_content)
    Button btnShareMultiPiecesContent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_text_content);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_share_text,
            R.id.btn_share_binary,
            R.id.btn_share_multi_pieces_content
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_share_text:
                shareTextData();
                break;
            case R.id.btn_share_binary:
                shareBinaryData();
                break;
            case R.id.btn_share_multi_pieces_content:
                shareMultiPiecesContent();
                break;
        }
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        getMenuInflater().inflate(R.menu.share_menu,menu);
//        MenuItem item = menu.findItem(R.id.menu_item_share);
//        item.getActionProvider();
//
//        return true;
//    }

    private void shareMultiPiecesContent() {
        ArrayList<Uri> imageUris = new ArrayList<Uri>();

        imageUris.add(Uri.parse("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2957043501,255162184&fm=58&s=2CA2A91ACCB44C801E7194D6010000B1")); // Add your image URIs here
        imageUris.add(Uri.parse("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1506010802,1895324471&fm=58&bpow=671&bpoh=409")); // Add your image URIs here

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
        shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
        shareIntent.setType("image/*");
        startActivity(Intent.createChooser(shareIntent, "Share images to.."));
    }

    private void shareBinaryData() {

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1506010802,1895324471&fm=58&bpow=671&bpoh=409"));
        shareIntent.setType("image/jpeg");
        startActivity(Intent.createChooser(shareIntent, getResources().getText(R.string.send_to)));

    }

    private void shareTextData() {

        Log.e(TAG, "shareTextContent: " + et.getText().toString());

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

}
