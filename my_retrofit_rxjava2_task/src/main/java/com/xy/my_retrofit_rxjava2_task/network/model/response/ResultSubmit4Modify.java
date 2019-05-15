package com.xy.my_retrofit_rxjava2_task.network.model.response;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class ResultSubmit4Modify {
    public int repeat_result;//批改结果是否一致。0未发生变化1由错批改为对2由对批改为错
    public boolean repeat_status;//是否是重复批改。
    public int update_status;//0:失败 1:成功
    public boolean is_postil = false;//是否是批注；
    public int error_code;
}
