package com.xy.my_retrofit_rxjava2_task.network.model.response;

import java.util.List;

/**
 * desc:批注提交结果
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultSubmit4Postil {
    List<TKT4PostilResult> tkt_merge_md5;//填空题
    public List<String> jdt_merge_md5;//简答题

    public class TKT4PostilResult {
        public int index;//坐标
        public String postt_svg;//新SVG地址
    }
}
