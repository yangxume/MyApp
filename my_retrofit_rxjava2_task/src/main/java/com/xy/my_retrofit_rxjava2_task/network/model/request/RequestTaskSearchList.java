package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * @author hesongchao
 * Created on 2019/3/4 15:53
 */
public class RequestTaskSearchList extends RequestBase {
    public int page = 1;//页数
    public String package_desc = "";//类型 6作业 7 测评 8 预习. 近期：6,7,8
    public int page_size = 10;//多少条数据
    public String scene_type="6,7,8";//6作业 7 测评 8 预习. 近期：6,7,8
}
