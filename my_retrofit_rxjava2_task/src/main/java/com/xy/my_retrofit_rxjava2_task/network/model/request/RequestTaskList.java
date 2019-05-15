package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc:请求任务列表页所需参数
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestTaskList extends RequestBase {
    public int page = 1;//页数
    public String scene_type = "6,7,8";//类型 6作业 7 测评 8 预习. 近期：6,7,8
    public int page_size = 12;//多少条数据
}
