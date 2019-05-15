package com.xy.my_retrofit_rxjava2_task.network.model.response;

/**
 * desc EventResultOrientation
 * <p>
 * Created on 17/9/26.
 * author: zhangpanzhao
 */

public class EventResultOrientation {
    public String slide;

    public Audio audio;

    public class Audio {
        public String name;
        public long size;
        public String url;
    }
}
