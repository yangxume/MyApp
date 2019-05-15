package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teachertasklib.network.model.base.QuestionInfo;

import java.util.List;

/**
 * desc:按人查看报告
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultSReport {

    public List<SReportType> question_list;
    public List<SReportType> question_speaking;
    public List<Knowledge> knowledge_list;
    public double accuracy;//总正确率
    public double excellence; // 优秀率
    public String submit_time;//提交时间
    public String use_time;//作答时长
    public boolean show_correct_flag;//未批标志.false:未批 true:部分已批或已批
    public int without_delay;//1未超时 2 超时 (只有作业，预习有该状态)
    public boolean is_rectify;
    /**
     * 听口题添加： 1、只有正确率，2只有优秀率，3都有
     */
    public int qtype_flag;

    public float stu_score;//个人得分，字段名待定
    public float total_score;//题集总分，字段名待定

    public class SReportType {
        public int count;//数量eg:正确100人
        public List<QuestionInfo> questions;
        public String type;//type对应的：1：对 2:错 5:半对 6:未批改
    }

    public class Knowledge {
        public double p_accuracy;//知识点正确率
        public String p_id;//知识点ID
        public String p_name;//知识点名称
    }
}
