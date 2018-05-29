package com.xy.lrucache;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/5/29 15:15
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description  LruCache use : https://blog.csdn.net/guolin_blog/article/details/9526203
 * <p>
 * Update records:
 */
public class ActivityPhotoWall extends AppCompatActivity {

    private static final String TAG = "ActivityPhotoWall";
    private GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_photowall);

        initView();

        initAdapter();
    }

    private void initAdapter() {

    }

    private void initView() {

        gridView = findViewById(R.id.gridView);

    }
}
