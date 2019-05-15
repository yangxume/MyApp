package com.xy.my_retrofit_rxjava2_task.network.model.base;

import java.util.List;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class QuestionInfo {
    public Long q_id;//题目ID
    public String q_name;//题目名称
    public int q_type;//题目类型
    public int q_structId;//题目结构ID
    public int q_serialNumber;//题目序号
    public boolean intelligent;//是否只能批注
    public List<String> optionName;//选项名称
    public List<QuestionInfo> subQuestion;//复合题信息

    public float q_score;//单题分值，字段名待定
    public float q_stu_score;//单题个人得分，字段名待定

    public int subject_id; // 英语作文，学科ID
    public String status; // 题是否停用
}
