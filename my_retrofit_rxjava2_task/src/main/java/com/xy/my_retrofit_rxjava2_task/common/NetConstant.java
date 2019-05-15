package com.xy.my_retrofit_rxjava2_task.common;

/**
 * desc:网络请求常量集
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */

public class NetConstant {
    public static final int NET_CODE_SUCCESS = 0;//成功
    public static final int NET_CODE_FAILURE = -1;//失败
    public static final int NET_CODE_INVALID_TOKEN = 1110002;//token失效
    public static final int NET_CODE_RESOURCE_NOT_FOUND = 1000103;//资源未找到
    public static final int NET_CODE_ILLEGAL_INPUT = 2000;//输入参数不合法
    public static final int NET_CODE_ERROR_USER_MODIFY_PASSWORD = 2002;//用户修改密码失败
    public static final int NET_CODE_ERROR_USER_OLD_PASSWORD = 2003;//当前密码不正确，请重新输入
    public static final int NET_CODE_ERROR_USER_UPLOAD_AVATAR = 2004;//上传头像失败，请重新上传
    public static final int NET_CODE_ERROR_USER_ACCOUNT_PWD = 2005;//账号或密码错误，请重新输入
    public static final int NET_CODE_ERROR_USER_NO_AUTHOR = 2006;//只有任课老师或班主任可以登录教师PAD
    public static final int NET_CODE_ERROR_USER_NO_DISRECTORY = 2007;//请先前往网站端教师空间以完善教学信息
    public static final int NET_CODE_ERROR_USER_NO_LOGIN = 2008;//请先登录
    public static final int NET_CODE_ERROR_CONNECT = 2009;//通讯系统故障，请稍后再试
    public static final int NET_CODE_ERROR_DB = 2010;//后台存储系统故障
    public static final int NET_CODE_ERROR_SERVICE_THROWABLE = 2011;//教师PAD暂时无法提供服务，请稍后再试
    public static final int NET_CODE_ERROR_SERVICE = 2012;//后台系统故障
    public static final int NET_CODE_ERROR_OPERATE = 2013;//操作失败
    public static final int NET_CODE_ERROR_SERVICE_CONNECT = 2014;//课程通讯服务故障，请稍后再试
}
