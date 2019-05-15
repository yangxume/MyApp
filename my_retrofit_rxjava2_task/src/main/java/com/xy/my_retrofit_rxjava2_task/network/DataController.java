package com.xy.my_retrofit_rxjava2_task.network;

import android.text.TextUtils;

import com.xy.my_retrofit_rxjava2_task.common.NetConstant;
import com.xy.my_retrofit_rxjava2_task.network.model.base.BaseBean;
import com.xy.my_retrofit_rxjava2_task.network.model.request.RequestTaskList;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Dispatcher;


/**
 * desc:DataController
 *
 * @author zhaodongdong
 *         QQ: 97966693
 *         email: androidmdeveloper@163.com
 */
public class DataController {

    //                public static String BASE_URL = "http://172.16.20.132:8080/";
    public static String BASE_URL = "http://10.60.0.62:7009/";
    public static String BASE_URL_UPGRADE = "http://app.studentpad.xk12.cn/";
    //    public static String BASE_URL = "http://moco.okzhihui.cn/mockjsdata/73/";
    public static final String LOG_PRINT = "http://10.60.0.46:8003/";
    public static String BASE_URL_OWA;
    private Map<String, Disposable> mServices = new HashMap<>();
    private static HttpService mService;

    /**
     * @param baseUrl baseUrl null使用的是默认url
     * @return DataController
     */
    public static DataController getInstance(String baseUrl) {
        DataController instance;
        if (TextUtils.isEmpty(baseUrl)) {
            instance = new DataController(BASE_URL);
        } else {
            instance = new DataController(baseUrl);
        }
        return instance;
    }

    public Map<String, Disposable> getServices() {
        return mServices;
    }

    private DataController(String baseUrl) {
        mService = NetApi.getInstance(baseUrl).getRetrofit().create(HttpService.class);
    }

    /**
     * Simple Data
     *
     * @param response response
     * @param <T>      T
     * @return Subscriber
     */
    private <T> Observer<? super BaseBean<?>> createSimpleSubscriber(final String identify, final NetResponse<T> response) {

        return new Observer<BaseBean<?>>() {
            @Override
            public void onError(Throwable e) {
                detailError(e, response);
                mServices.remove(identify);
            }

            @Override
            public void onComplete() {
                response.onCompleted();
                mServices.remove(identify);
            }

            @Override
            public void onSubscribe(Disposable disposable) {
                mServices.put(identify, disposable);
            }

            @Override
            public void onNext(BaseBean<?> baseBean) {
                if (baseBean.meta.ecode == NetConstant.NET_CODE_SUCCESS) {
                    response.onSuccess((BaseBean<T>) baseBean);
                } else {
                    detailCode(baseBean.meta.ecode, baseBean.meta.emsg, response);
                }
            }
        };
    }

    /**
     * 集中处理其他异常code
     *
     * @param code code
     * @param emsg
     */
    private void detailCode(int code, String emsg, NetResponse response) {
        switch (code) {
            case NetConstant.NET_CODE_ERROR_USER_NO_LOGIN:
                try {
                    JSONObject jsonObject = new JSONObject();
                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject.put("pkg", "com.okay.teachertasklib");
                    jsonObject1.put("pkg", "com.okay.teachertasklib");
                    jsonObject1.put("reason", "token失效");
//                    Dispatcher.get().post(ActionCreator.make(AccountActionDefine.LOGIC_FOUND_TOKEN_INVALID, jsonObject1.toString()));
//                    Dispatcher.get().post(ActionCreator.make(AccountActionDefine.USER_LOGIN, jsonObject.toString()));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;
            default:
                response.onSuccessError(code, emsg);
                break;
        }

    }

    /**
     * 处理错误逻辑
     *
     * @param e        exception
     * @param response response
     */
    private void detailError(Throwable e, NetResponse response) {
        response.onError(e);
    }


    //<---------------------------------------我是分割线------------------------------------------>


    //任务列表
    public <T> void taskList(NetResponse<T> response, RequestTaskList list) {
        mService.taskList(list)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(createSimpleSubscriber("taskList", response));
    }
}
