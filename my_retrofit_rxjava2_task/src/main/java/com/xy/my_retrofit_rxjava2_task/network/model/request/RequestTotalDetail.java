package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc:总体详情Request
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestTotalDetail extends RequestBase {
    public String link_id;//link_ID
    public String r_id;//资源ID
    public String scene_type;//资源类型
    public int show_type = 1;//类型：1:按题 2:按人查看,默认为1
    public int seq; // v1.3.7 添加 排序 （按人-->默认:0提交时间 1正确率，2优秀率，3作答时长）(按题-->默认:0题号 1正确率，2优秀率)
    public int sort; // v1.3.7添加（只有show_type ==1,2有效）
}
