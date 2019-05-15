package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teacher.englishcorrectdetail.EnglishCorrectBean;

/**
 * <pre>
 *     author : per4j
 *     e-mail : zhangpanzhao@okay.cn
 *     time   : 2018/09/27
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ResultEnglishCorrection {
    public EnglishCorrectBean thpResult;
    
    public String s_name;//学生姓名
    public String s_portrait;//学生头像

    public String link_id;                  // link_id
    public String publish_id;               // 发布id
    public String question_id;              // 题目id（大题）
    public String resource_id;              // 资源id
    public String scene_type;               // 6作业 7 测评 8 预习。必填
    public Long student_id;   // 学生id
}
