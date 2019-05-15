package com.xy.my_retrofit_rxjava2_task.network.model.request;


import com.xy.my_retrofit_rxjava2_task.network.model.base.RequestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestSubmit4Modify extends RequestBase {
    public String publish_id;
    public String question_id;
    public String link_id;
    public String scene_type;
    public String struct_id;//题型结构（如果sub_question_id存在时则为小题题型结构）
    public String student_id;
    public String sub_question_id;
    public int type;
    public Float q_score; // 单题总分 分值需求
    public List<SubmitAnswer> answer = new ArrayList<>();
}
