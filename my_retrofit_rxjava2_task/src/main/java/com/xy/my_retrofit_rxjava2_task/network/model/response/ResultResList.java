package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teachertasklib.network.model.base.ResultBase;

import java.util.List;

/**
 * desc:资源列表详情
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultResList extends ResultBase {
    public long answer_publish_time;//公布答案时间
    public long publish_time;//发布时间
    public int cancel_event;//是否可取消 1可取消 0不可取消
    public int is_publish;//是否发布：0：未发布（定时发布） 1：已发布
    public int is_publish_answer;//是否已经公布答案（1.2.1）0:否 1：是
    public String publish_name;//发布名称
    public String chaper_info;//章节信息
    public List<ResList> list;//资源列表集

    public static class ResList {
        public String link_id;//linkID
        public String resource_id;//资源ID
        public String resource_kind;//资源种类
        public String resource_name;//资源名称
        public int resource_type;//资源类型
        public int student_count;//学生总数
        public int study_count;//预习人数
        public int submit_count;//提交人数
        public int unmodified_count;//未批改人数
    }
}
