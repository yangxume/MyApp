package com.xy.okhttp_interceptor.net.result;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.JsonElement;
import org.json.JSONException;
import org.json.JSONObject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
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
            Log.e(TAG, "Exception Name:" + e.getClass().getName());
        }
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
                jsonObject.put("ecode", ecode);
                jsonObject.put("msg", msg);
                if (null != extra) {
                    jsonObject.put("extra", extra);
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
