package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teachertasklib.network.model.base.QuestionInfo;
import com.okay.teachertasklib.network.model.base.StudentInfo;

import java.util.List;

/**
 * desc:按题查看报告
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultQReport {
    public List<RQuestions> report;
    public List<StudentInfo> stuInfoList;
    public String type;//是否为复合题1:复合 0:单题
    public double accuracy;//总正确率
    public double excellence; // 优秀率
    public boolean show_correct_flag;//未批标志.false:未批 true:部分已批或已批

    public class RQuestions extends QuestionInfo {
        public Component result;
    }

    public class Component {
        public List<Distribute> distribute;//选项分布
        public List<QReportType> types;//类型集：正确，错误，未批改等等
        public List<AudioTypes> audioTypes; // 听口题
    }

    public class AudioTypes {
        public int index;//题目序号
        public List<SStatistics> stu_info;//各分布下学生统计信息
    }

    public class Distribute {
        public int index;//题目序号
        public List<SStatistics> stu_info;//各分布下学生统计信息
    }

    public class QReportType {
        public double accuracy;//正确率
        public int index;//题目序号
        public List<SStatistics> stu_info;//各分布下学生统计信息
    }

    public class SStatistics {
        public List<Long> stu_ids;//学生ids
        public String type;//选项分布的类型（A,B,C,D）
        public int count;//当前类型下分布的数量

    }

    public class ReportQType {
        public QReportType qType;
        public String type;
    }
}
