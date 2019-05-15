package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestCancelTask extends RequestBase {
    public String publish_id;//发布ID
    public String reason;//reasonID
    public String type;//取消类型
}
