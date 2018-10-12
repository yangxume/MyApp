package com.okay.myapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.okay.myapp.bean.LeakSingle;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/10/11 16:36
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class Activity12_LeakBlock extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity12_leak_block);

        TextView tv = findViewById(R.id.textview);

        LeakSingle.getInstance(this).setRetainedTextView(tv);

        testBlockCanary();

    }

    private void testBlockCanary() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
