package com.xy.my_retrofit_rxjava2_classroom.net.base.result;

import android.text.TextUtils;

import com.google.gson.JsonElement;
import com.xy.my_retrofit_rxjava2_classroom.net.LogUtil;
import com.xy.my_retrofit_rxjava2_classroom.net.constants.ParamConstant;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

/**
 * Created on 17/3/15.
 * author: yuanbaoyu
 */
public abstract class BaseObserver<T> implements Observer<T> {
    private static final String TAG = "BaseObserver";

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T value) {
        next(value);
    }

    @Override
    public void onError(Throwable e) {
        if (e != null) {
            LogUtil.e(TAG, "Exception Name:" + e.getClass().getName());
            LogUtil.e(TAG, e.getMessage());

        }
//        if (e instanceof HttpException) {
//            LogUtil.e(TAG, ((HttpException) e).message());
//            error(createError(((HttpException) e).code(), ((HttpException) e).message()));
//        } else if (e instanceof TimeoutException) {
//            LogUtil.e(TAG, "网络连接超时");
//            error(createError(ErrorCodeConstant.TIMEOUT, e.getMessage()));
//        } else if (e instanceof UnknownHostException) {
//            LogUtil.e(TAG, "网络地址解析失败");
//            error(createError(ErrorCodeConstant.NO_NET, e.getMessage()));
//        } else if (e instanceof ConnectException) {
//            LogUtil.e(TAG, "网络地址连接失败");
//            error(createError(ErrorCodeConstant.NO_NET, e.getMessage()));
//        } else if (e instanceof NoRouteToHostException) {
//            LogUtil.e(TAG, "防火墙设置可能阻挡此类程序访问网络 或 可能那个端口被屏蔽了--message:" + e.getMessage());
//            error(createError(ErrorCodeConstant.NO_NET, e.getMessage()));
//        } else if (e instanceof TokenInvalidException) {
//            LogUtil.e(TAG, "token失效");
//            //TODO token失效处理
//            AccountManager.getInstance().onTokenInvalid();
//        } else if (e instanceof SocketTimeoutException) {
//            LogUtil.e(TAG, e.getMessage());
//            error(createError(ErrorCodeConstant.SOCKET_CONNECT_TIMEOUT, e.getMessage()));
//        } else if (e instanceof ApiException) {
//            LogUtil.e(TAG, e.getMessage());
//
//            String extra = ((ApiException) e).getExtra();
//
//            if (TextUtils.isEmpty(extra)) {
//                error(createError(((ApiException) e).getEcode(), e.getMessage(), null));
//            } else {
//                try {
//                    error(createError(((ApiException) e).getEcode(), e.getMessage(), new JSONObject(extra)));
//                } catch (JSONException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        } else {
//            LogUtil.e(TAG, e.getMessage());
//            error(createError(ErrorCodeConstant.UNKNOWN, e.getMessage()));
//        }
    }

    @Override
    public void onComplete() {
        complete();
    }

    public abstract void next(T value);

    public abstract void error(ErrorMsg msg);

    public abstract void complete();

    private ErrorMsg createError(int code, String msg, JSONObject extra) {
        return new ErrorMsg(code, msg, extra);
    }

    private ErrorMsg createError(int code, String msg) {
        return createError(code, msg, null);
    }


    public static class ErrorMsg {
        private int ecode;
        private String msg;
        private JSONObject extra;

        public ErrorMsg(int ecode, String msg, JSONObject extra) {
            this.ecode = ecode;
            this.msg = msg;
            this.extra = extra;
        }

        public void addExtra(String key, String value) throws JSONException {
            if (extra == null) {
                extra = new JSONObject();
            }
            extra.put(key, value);
        }

        public void setEcode(int ecode) {
            this.ecode = ecode;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public void setExtra(String property, String value) {
            if (!TextUtils.isEmpty(property)) {
                if (this.extra == null) {
                    this.extra = new JSONObject();
                }
                try {
                    this.extra.put(property, value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setExtra(String property, JsonElement value) {
            if (!TextUtils.isEmpty(property)) {
                if (this.extra == null) {
                    this.extra = new JSONObject();
                }
                try {
                    this.extra.put(property, value);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        private JSONObject build() {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put(ParamConstant.ECODE, ecode);
                jsonObject.put(ParamConstant.EMSG, msg);
                if (null != extra) {
                    jsonObject.put(ParamConstant.EXTRA, extra);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject;
        }

        @Override
        public String toString() {
            return this.build().toString();
        }
    }
}
