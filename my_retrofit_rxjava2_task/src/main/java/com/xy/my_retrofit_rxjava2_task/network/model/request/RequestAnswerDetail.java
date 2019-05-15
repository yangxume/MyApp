package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc:获取作答情况
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestAnswerDetail extends RequestBase {
    public String link_id;//link_id资源对应LinkID
    public String publish_id;//发布ID
    public String question_id;//题集ID
    public String resource_id;//资源ID
    public String q_flag;
    public String student_id;//学生ID
    public String scene_type;//资源类型 "6","7","8","6,7,8"
}
