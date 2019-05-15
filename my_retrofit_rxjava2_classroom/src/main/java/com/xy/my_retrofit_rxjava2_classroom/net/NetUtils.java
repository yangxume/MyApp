package com.xy.my_retrofit_rxjava2_classroom.net;

import com.google.gson.JsonObject;
import com.xy.my_retrofit_rxjava2_classroom.net.base.RetrofitClient;
import com.xy.my_retrofit_rxjava2_classroom.net.base.params.CommonJsonObject;
import com.xy.my_retrofit_rxjava2_classroom.net.base.result.BaseObserver;
import com.xy.my_retrofit_rxjava2_classroom.net.base.result.HttpResult;
import com.xy.my_retrofit_rxjava2_classroom.net.base.result.RxResultHelper;
import com.xy.my_retrofit_rxjava2_classroom.net.base.schedulers.RxSchedulersHelper;
import com.xy.my_retrofit_rxjava2_classroom.net.constants.ParamConstant;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.xy.my_retrofit_rxjava2_classroom.net.constants.ParamConstant.CLASS_ID;
import static com.xy.my_retrofit_rxjava2_classroom.net.constants.ParamConstant.PAGE;
import static com.xy.my_retrofit_rxjava2_classroom.net.constants.ParamConstant.TOKEN;
import static com.xy.my_retrofit_rxjava2_classroom.net.constants.ParamConstant.UID;

public class NetUtils {



    /**
     * 查询已发布课程
     *
     * @param class_id 班级ID
     * @param page     页码，从1开始
     * @param token
     * @param uid
     * @return
     */
    public static void queryCourses(final String class_id, String page, String token, String uid, final String typePublish) {
        JsonObject jsonObject = CommonJsonObject.getCommonJsonObject();
        jsonObject.addProperty(CLASS_ID, class_id);
        jsonObject.addProperty(PAGE, page);
        jsonObject.addProperty(TOKEN, token);
        jsonObject.addProperty(ParamConstant.TYPE_PUBLISH, typePublish);
        jsonObject.addProperty(UID, uid);

        RetrofitClient.getInstance()
                .create(ApiService.class)
                .queryCourses(jsonObject)
                .compose(RxResultHelper.<JsonObject>handleResult(RxSchedulersHelper.<JsonObject>io()))
//                .compose(RxResultHelper.<JsonObject>handleResult())
                .subscribe(new BaseObserver<JsonObject>() {
                    @Override
                    public void next(JsonObject value) {
//                        value.addProperty(CLASS_ID, class_id);
//                        value.addProperty(TYPE_PUBLISH, typePublish);
//                        Dispatcher.get().post(ActionCreator.make(CLASS_LIST_RESULT_TAB_CONTENT, value.toString()));
                    }

                    @Override
                    public void error(ErrorMsg msg) {
//                       spatcher.get().post(ActionCreator.make(CLASS_LIST_RESULT_TAB_CONTENT, msg.toString()));
                    }

                    @Override
                    public void complete() {
                    }
                });
    }


}