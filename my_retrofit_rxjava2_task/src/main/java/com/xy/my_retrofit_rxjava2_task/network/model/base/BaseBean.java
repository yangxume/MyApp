package com.xy.my_retrofit_rxjava2_task.network.model.base;

/**
 * desc:BaseBean
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */
public class BaseBean<T> {
    public MetaBean meta;
    public T data;

    public class MetaBean {
        public int ecode;
        public String emsg;
    }
}
