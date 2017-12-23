package com.okay.myapp.v4;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/12/20 14:55
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
             android.media 兼容库，
             包括 MediaBrowser 和 MediaSession，大小为 248k
             'com.android.support:support-media-compat:24.2.1'
 * Update records:
 */

public class ActivitySupportMediaCompat extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String extraPageSize = MediaBrowserCompat.EXTRA_PAGE_SIZE;

        MediaSessionCompat mediaSessionCompat = MediaSessionCompat.fromMediaSession(ActivitySupportMediaCompat.this, null);



    }
}
