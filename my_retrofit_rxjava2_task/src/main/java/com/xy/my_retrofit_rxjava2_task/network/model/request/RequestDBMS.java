package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.t_personalcenterlib.AccountStore;
import com.okay.teachertasklib.BuildConfig;
import com.okay.teachertasklib.network.model.response.ResultSubmit4Modify;

/**
 * desc:数据打点参数
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestDBMS {
    public AppInfo app_info = new AppInfo();
    public UserInfo user_info = new UserInfo();
    public ResourceInfo resource_info = new ResourceInfo();
    public TopicInfo question_info = new TopicInfo();
    public OperationInfo operation_info = new OperationInfo();
    public ResultSubmit4Modify correct_result = new ResultSubmit4Modify();
    public long date_time;//当前时间
    public int log_type;//2-批改7-任务查看/查看任务中习题报告

    public class AppInfo {
        public int app_id = 3;//必选1- 上课2- 任务3- 个人中心4-其他（网络，桌面，系统更新，应用更新
        public String app_version = BuildConfig.VERSION_NAME;//App版本号
        public long subject_id;//科目ID
    }

    public class UserInfo {
        public Long uid = Long.parseLong(AccountStore.get().getCurrentUid());//用户ID
        public Long class_id;//班级ID
    }

    public class OperationInfo {
        public int operation_type;//15-查看任务详情16-所有批改行为17-任务中习题报告的查看（按学生查看，按照题目查看）18-任务中学生报告中习题批改结果查看
        public Long operation_target_id;//操作对象Id 例如（课程id、资料id、题集id，题目id)
    }

    public class TopicInfo {
        public String exersice_id;//题集id
        public int exersice_type;//题集类型
        public TopicList question_list = new TopicList();
    }

    public class TopicList {
        public Long question_id;//题目id
        public int question_type;//题目类型
        public String scene_type;//"6","7","8"
        public Long question_sub_id;//复合题的小题ID
        public Long operation_time;//操作时间
        public String report_group;//1-对 2-错  5-半对半错 6-有答案为批改  7-无答案
        public int check_method;//1-按人名查看3-按照题目查看（仅限于任务中的习题报告）
    }

    public class ResourceInfo {
        public int resource_type;//资源类型1: PPT；2:WORD；3: 图片；4:视频；5: 音频；6:FLASH7:PDF8:EXCEL
        public Long resource_id;//资源ID
        public String scene_type;//"6","7","8"
        public Long course_id;//课程ID
        public String resource_kind;//资源种类1.课件2.习题3.教学资料
        public Long operation_time;//操作时间
    }
}
