package com.xy.my_retrofit_rxjava2_classroom.net.constants;

/**
 * 错误码定义
 * Created on 17/3/16.
 * author: yuanbaoyu
 */
public class ErrorCodeConstant {

    //未知错误
    public static final int UNKNOWN = -1;

    //成功
    public static final int SUCCESS = 0;

    /**
     * token失效
     */
    public static final int TOKEN_INVALID = 2008;
    public static final int SOCKET_TOKEN_INVALID = 1004;

    /**
     * 课堂控制模式不一致
     */
    public static final int CONTROL_INCONSISTENT = 2015;

    //超时
    public static final int TIMEOUT = 9001;

    //无网
    public static final int NO_NET = 9002;

    public static final int ECODE_NULL = -100;


    public static final int LOADING = 1901;

    public static final int LOADING_FAILURE = 60002;//自定义数据加载失败

    //长连接连接错误
    public static final int SOCKET_CONNECT_ERROR = 9100;
    //长连接连接超时
    public static final int SOCKET_CONNECT_TIMEOUT = 9101;
    //长连接重连错误
    public static final int SOCKET_RECONNECT_ERROR = 9102;

    //上课错误
    public static final int SOCKET_INTO_CLASS_ERROR = 9103;
    //后台系统异常
    public static final int SERVICE_ERROR = 2012;
    //教师Pad 暂时无法提供服务，请稍后再试
    public static final int SERVICE_THROWABLE = 2011;
    //通讯系统故障
    public static final int SOCKET_COMM = 2009;

    public static final int SERVICE_NOT_FOUND = 404;

    public static final int SERVICE_BAD_GATEWAY=502;

    public static final int START_CLASS_FAILED_CANCEL_REASON=60055;
}
