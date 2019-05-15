package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc:请求资源预习情况参数
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestResource extends RequestBase {
    public String publish_id;//发布ID
    public String r_id;//资源ID
    public int r_type;//资源类型
    public String scene_type;//资源类型
    public String link_id;//link_ID
}
