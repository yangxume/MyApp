package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.spoke.Spoken;
import com.okay.teachertasklib.network.model.base.QuestionInfo;
import com.okay.teachertasklib.network.model.base.ResultBase;
import com.okay.teachertasklib.network.model.base.StudentInfo;

import java.util.List;

/**
 * desc:作答情况详情
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultAnswerDetail extends ResultBase {
    public double accuracy = 0;//正确率
    public double excellence = -1; // 优秀率，非听口题为-1
    public int ai_status;//1:支持 0:不支持
    public List<AnswerDetails> list;
    public String next;
    public boolean show_correct_flag;//未批标志.false:未批 true:部分已批或已批
    public int qtype_flag;//听口题添加： 1、只有正确率，2只有优秀率，3都有

    public class AnswerDetails {
        public StudentInfo stuInfo;
        public QuestionInfo qInfo;
        public boolean is_rectify;//是否批改
        public boolean is_postil;//是否批注
        public boolean is_ai;//是否智能批改 智批自动生效
        public int is_white_list; // 智批生效 1 生效 0 不生效
        public List<AnswerDetail> answer;
        public List<SubAnswerDetail> sub_questions;//复合题

        public boolean is_white_list() {
            return is_white_list == 1;
        }
    }

    public class SubAnswerDetail {
        public StudentInfo stuInfo;
        public QuestionInfo qInfo;
        public boolean is_rectify;//是否批改
        public boolean is_postil;//是否批注
        public boolean is_ai;//是否只能批改 智批自动生效
        public int is_white_list; // 智批生效 1 生效 0 不生效
        public List<AnswerDetail> answer;

        public boolean is_white_list() {
            return is_white_list == 1;
        }
    }

    public class AnswerDetail {
        public String index = "1";//题目索引
        public String posttl_role;//批改人
        public List<String> posttl_svg;//批改Svg
        public List<String> posttl_url;//作答结果
        public List<String> posttl_svg_ai;//智能批注结果
        public List<Integer> status_src;//七选五对应的状态
        public int status;//批改状态1：对 2:错 5:半对 6:未批改
        public Spoken speaking; // 听口题
    }
}
