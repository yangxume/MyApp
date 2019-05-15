package com.xy.my_retrofit_rxjava2_task.network.model.base;

/**
 * desc:
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class Interaction<T> {
    /**
     * type:
     */
    public String type;

    public T data;

    public String userAction;

    public String accessory;//附件
}
