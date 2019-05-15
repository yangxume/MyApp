package com.xy.my_retrofit_rxjava2_classroom.net.base.result;

/**
 * Created on 17/3/15.
 * author: yuanbaoyu`
 */
public class HttpResult<T> {

    public MetaBean meta;
    public T data;

    public static class MetaBean {
        public int ecode;
        public String emsg;
    }
}
