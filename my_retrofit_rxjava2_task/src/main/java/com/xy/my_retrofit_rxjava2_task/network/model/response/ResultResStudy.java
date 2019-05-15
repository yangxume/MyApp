package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teachertasklib.network.model.base.StudentInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * desc:资源预习情况
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultResStudy {
    public List<ResStudy> list = new ArrayList<>();
    public String title;

    public class ResStudy {
        public StudentInfo stuInfo;
        public int study_state;//预习状态 1:已预习 2:逾期预习 3:未预习
    }
}
