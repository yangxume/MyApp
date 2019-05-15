package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestSubmit4Clever extends RequestBase {
    public String scene_type;//"6"，"7"，"8"
    public String question_id;//题目ID
    public String publish_id;
    public String struct_id;//结构ID
    public String link_id;//link_ID
    public String student_id;
}
