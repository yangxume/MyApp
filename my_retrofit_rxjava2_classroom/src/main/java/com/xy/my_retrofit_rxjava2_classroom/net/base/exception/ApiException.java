package com.xy.my_retrofit_rxjava2_classroom.net.base.exception;

/**
 * Created on 17/3/15.
 * author: yuanbaoyu
 */
public class ApiException extends RuntimeException {

    private int ecode;

    private String extra;
//    private String message;

    public ApiException(int resultCode, String emsg, String extra) {
        super(emsg);
        ecode = resultCode;
        this.extra = extra;
    }

    public String getExtra() {
        return extra;
    }

    //    @Override
//    public String getMessage() {
//        return message;
//    }

    public int getEcode() {
        return ecode;
    }

    //    /**
//     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
//     * 需要根据错误码对错误信息进行一个转换，在显示给用户
//     * @param code
//     * @return
//     */
//    private String getApiExceptionMessage(int code){
//        switch (code) {
//            case USER_NOT_EXIST:
//                message = "该用户不存在";
//                break;
//            case WRONG_PASSWORD:
//                message = "密码错误";
//                break;
//            default:
//                message = "未知错误";
//        }
//        return message;
//    }
}
