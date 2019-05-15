package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

/**
 * desc RequestRectifyAll
 * <p>
 * Created on 18/1/8.
 * author: zhangpanzhao
 */

public class RequestEnglishCorrection extends RequestBase {
    public String link_id;                  // link_id
    public String publish_id;               // 发布id
    public String question_id;              // 题目id（大题）
    public String resource_id;              // 资源id
    public String scene_type;               // 6作业 7 测评 8 预习。必填
    public Long student_id;   // 学生id
}
