package com.xy.my_retrofit_rxjava2_task.network;


import com.xy.my_retrofit_rxjava2_task.network.model.base.BaseBean;

/**
 * desc:网络请求回调
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public abstract class NetResponse<T> {

    public NetResponse() {
    }

    /**
     * 错误
     *
     * @param e exception
     */
    public abstract void onError(Throwable e);

    /**
     * 数据
     *
     * @param data data
     */
    public abstract void onSuccess(BaseBean<T> data);

    /**
     * 完成
     */
    public abstract void onCompleted();

    public void onSuccessError(int code, String emsg) {

    }
}
