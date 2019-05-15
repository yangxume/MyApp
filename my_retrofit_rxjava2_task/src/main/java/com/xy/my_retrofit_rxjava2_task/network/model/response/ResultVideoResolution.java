package com.xy.my_retrofit_rxjava2_task.network.model.response;

import java.util.List;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/8/23 10:38
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class ResultVideoResolution {

    public List<VideoResolution> resList;

    public class VideoResolution {

        /**
         * 0流畅、1清晰、2高清、99原始
         */
        public int resolutionType;
        /**
         * 4音频 5视频
         */
        public int resourceType;

        public String videoUrl;

        public long fileSize;

        public int duration;

        public long resourceId;
    }

}
