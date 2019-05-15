package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teachertasklib.network.model.base.QuestionInfo;
import com.okay.teachertasklib.network.model.base.StudentInfo;

import java.util.List;

/**
 * desc:总体详情
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultTotalDetail {
    public List<QTotalDetail> question_list;
    public List<STotalDetail> student_list;
    public List<UnSTotalDetail> un_sub_student_list;
    public int show_type; // 1､只有正确率，2､只有优秀率，3､都有
    public int seq;
    public int sort;
    public int qtype_flag; // 1､只有正确率，2､只有优秀率，3､都有
    public float total_score; // 题集总分 --分值需求

    public class UnSTotalDetail {
        public StudentInfo stuInfo;
    }

    public class QTotalDetail {
        public double accuracy;//正确率
        public int answer_num;//	总回答数
        public double excellence;//优秀率，不是听口题传-1
        public QuestionInfo qInfo;
        public int un_correct_num;//未批人数
        public String status; // 停用 DISABLED 非 停用 ENABLED
    }

    public class STotalDetail {
        public double accuracy;//正确率
        public int question_count;//总题数
        public StudentInfo stuInfo;
        public int un_correct_num;//未批题数
//        public String answer_duration;//作答时长 04:30
        public long use_time;//作答时长 04:30
        public double excellence;//优秀率，不是听口题传-1
        public int qtype_flag; // 1､只有正确率，2､只有优秀率，3､都有
        public float stu_score; // 个人得分 --分值需求
        public boolean is_rectify;
    }
}
