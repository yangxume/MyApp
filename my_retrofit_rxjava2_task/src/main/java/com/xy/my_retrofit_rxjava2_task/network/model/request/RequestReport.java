package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestReport extends RequestBase {
    public String link_id;//link_ID
    public String student_id;//学生ID
    public String question_id;//题目ID
    public String scene_type;//题集来源6:作业 7:测试 8:预习
    public String q_flag;//是否为复合题,1:复合 0:单题
    public String resource_id;//资源ID
}
