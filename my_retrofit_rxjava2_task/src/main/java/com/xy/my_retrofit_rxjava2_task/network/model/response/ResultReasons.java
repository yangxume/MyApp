package com.xy.my_retrofit_rxjava2_task.network.model.response;

import com.okay.teachertasklib.network.model.base.ResultBase;

import java.util.List;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultReasons  extends ResultBase{
    public List<Reasons> list;
    public long time;

    public static class Reasons {
        public int id;//reasonID
        public String content;//reason内容
    }
}
