package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teachertasklib.network.model.base.ResultBase;

/**
 * desc:资源详情
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultResDetail extends ResultBase {
    public Object question_info;//习题集的Json
    public boolean isPreview = false;
    public String preContent;
    public Long uncorrect_id;//第一个未批改题目的ID，没有未批则为0
    public ResInfo file_info = new ResInfo();//文件信息


    public class ResInfo {
        public String file_path;
        //        public String file_format;
        public String type_res_file;
    }
}
