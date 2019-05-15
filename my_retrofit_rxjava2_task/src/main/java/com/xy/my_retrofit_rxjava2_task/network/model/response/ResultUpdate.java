package com.xy.my_retrofit_rxjava2_task.network.model.response;

import java.util.List;

/**
 * Created on 17/6/9.
 * author: yuanbaoyu
 */
public class ResultUpdate {

    public List<AppsBean> apps;

    public static class AppsBean {
        public String size;
        public String icon;
        public String md5;
        public int vcode;
        public String url;
        public String title;
        public String desc;
        public String app;
        public int type;
        public String name;
        public String vname;
    }
}
