package com.okay.myapp.v4;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/20 14:59
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
             跟fragment相关部分，大小为 136k。
             V4这个子库依赖了其他4个子库，所以我们一旦依赖这个库就会自动导入其他4个子库，
             这跟直接依赖整个support-v4效果类似
 * Update records:
 */

public class ActivitySupportFragment extends FragmentActivity {

    Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        List<Fragment> fragments = supportFragmentManager.getFragments();


    }
}
