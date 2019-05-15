package com.xy.my_retrofit_rxjava2_task.network.model.response;

import java.util.List;

/**
 * desc:任务列表Bean
 *
 * @author zhaodongdong
 * QQ: 97966693
 * email: androidmdeveloper@163.com
 */

public class ResultTaskList {
    public List<TaskListItem> list;//列表信息集
    public int current_page;//当前的页数
    public int total_count;//总共数量
    public int total_page;//总共的页数

    public static class TaskListItem {
        public String publish_id;//发布ID
        public String publish_name;//发布名称
        public String scene_type;//发布类型
        public String chaper_info;//章节信息
        public String grade_name;//年级
        public int is_publish;//0：未发布（定时发布） 1：已发布
        public long service_corrent_time;//服务器当前时间
        public int target_type;// 发布方式 0-按照班级发布；1-单个学生发布  2-按组发布
        public String target_info;//班级名称
        public int student_count;//学生总数量
        public int exercise_count;//题集个数
        public int resource_count;//资源个数（ppt,word等非题集)
        public int use_time;//限时分钟
        public long end_time;//截止时间
        public long start_time;//发布时间
        public long anwser_publish_time;//题集答案公布时间
        public int study_count;//预习人数,无资源则无此状态
        public int submit_count;//提交的学生数量,无题集则无此状态
        public int unmodified_count;//未批改人数,无题集则无此状态
        public int task_state;//是否过期
        public int start_time_flag;//是否过期
    }
}
