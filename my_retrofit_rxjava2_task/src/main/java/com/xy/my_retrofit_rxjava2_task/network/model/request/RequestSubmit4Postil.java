package com.xy.my_retrofit_rxjava2_task.network.model.request;

import com.okay.teachertasklib.network.model.base.RequestBase;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:批改提交请求参数
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class RequestSubmit4Postil extends RequestBase {
    public String scene_type;
    public String link_id;
    public String publish_id;//发布ID
    public String question_id;//题目ID
    public String sub_question_id;//小题ID
    public String student_id;//学生ID
    public String struct_id;//题型结构ID
    public String jdt_answer;//简答题批改结果
    public JDTPostil jdt = new JDTPostil();

    public class JDTPostil {
        public List<String> posttl_prev;//上一次的批注图片文件名数组
        public List<String> posttl_add_svg;//批注svg数组
        public List<List<String>> posttl_del_svg=new ArrayList<>();//批注删除路径数组
    }
}
