package com.xy.retrofit.net;


import com.xy.retrofit.bean.AuditeInfoBean;
import com.xy.retrofit.bean.AuditeInfoCheckBean;
import com.xy.retrofit.bean.AuditeInfoDetailBean;
import com.xy.retrofit.bean.CardInfoBean;
import com.xy.retrofit.bean.CardUserinfoBean;
import com.xy.retrofit.bean.CommonBean;
import com.xy.retrofit.bean.ElectricInformationBean;
import com.xy.retrofit.bean.ElectricMonthDataBean;
import com.xy.retrofit.bean.LoginBean;
import com.xy.retrofit.bean.LogoutBean;
import com.xy.retrofit.bean.MyTest;
import com.xy.retrofit.bean.NotificationBean;
import com.xy.retrofit.bean.NotificationDetailBean;
import com.xy.retrofit.bean.OpinionSurveyBean;
import com.xy.retrofit.bean.OpinionSurveyProblemDetailBean;
import com.xy.retrofit.bean.RepairDetailBean;
import com.xy.retrofit.bean.RepairInfoBean;
import com.xy.retrofit.bean.RepairTrackingBean;
import com.xy.retrofit.bean.RepairTroubleBean;
import com.xy.retrofit.bean.UserConsumptionBean;
import com.xy.retrofit.bean.UserInfoBean;
import com.xy.retrofit.bean.UserReChargeBean;
import com.xy.retrofit.bean.WeatherBean;
import com.xy.retrofit.util.AppConstant;
import com.xy.retrofit.util.DataCache;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * mengCreated by dell on 2018/5/21.
 */
public class NetUtils {
    private NetUtils() {
    }

    public static NetUtils getInstance() {
        return MyHttpData.a;
    }

    private static class MyHttpData {
        public static NetUtils a = new NetUtils();
    }

    //测试接口
    public void getTest(Callback<MyTest> callback) {
        Call<MyTest> call = RetrofitManager.getInstance().getApiService().getData();
        call.enqueue(callback);
    }

    //登录接口
    public void getLogin(Callback<LoginBean> callback, RequestBody body) {

        Call<LoginBean> call = RetrofitManager.getInstance().getApiService().getLogin(body);
        call.enqueue(callback);

    }

    //退出接口
    public void getLogout(Callback<LogoutBean> callback) {
        Call<LogoutBean> call = RetrofitManager.getInstance().getApiService().getLogout();
        call.enqueue(callback);
    }

    //天气接口
    public void getWeather(Callback<WeatherBean> callback) {
        Call<WeatherBean> call = RetrofitManager.getInstance().getApiService().getWeather();
        call.enqueue(callback);
    }

    /***
     * 4.用户、一卡通
     */
    //    4.1用户信息
    public void getUserInfo(Callback<UserInfoBean> callback) {
        Call<UserInfoBean> call = RetrofitManager.getInstance().getApiService().getUserInfo();
        call.enqueue(callback);
    }

    //    4.2消费信息
    public void getConsumption(Callback<UserConsumptionBean> callback, RequestBody body) {
        Call<UserConsumptionBean> call = RetrofitManager.getInstance().getApiService().getConsumption(body);
        call.enqueue(callback);
    }

    //    4.3一卡通信息
    public void getCard(Callback<CardInfoBean> callback) {
        Call<CardInfoBean> call = RetrofitManager.getInstance().getApiService().getCard();
        call.enqueue(callback);
    }

    //    4.4充值信息
    public void getRecharge(Callback<UserReChargeBean> callback, RequestBody body) {
        Call<UserReChargeBean> call = RetrofitManager.getInstance().getApiService().getRecharge(body);
        call.enqueue(callback);
    }

    //    4.5持卡人基本信息
    public void getCardUserinfo(Callback<CardUserinfoBean> callback, RequestBody body) {
        Call<CardUserinfoBean> call = RetrofitManager.getInstance().getApiService().getCardUserinfo();
        call.enqueue(callback);
    }


    /**
     * 5 民意调查
     */
    //5.1民意调查列表
    public void getOpinionSurvey(Callback<OpinionSurveyBean> callback, RequestBody body) {
        Call<OpinionSurveyBean> call = RetrofitManager.getInstance().getApiService().getOpinionSurvey(body);
        call.enqueue(callback);
    }


    //5.2民意调查填写
    public void opinionSurveyProblemDetail(Callback<OpinionSurveyProblemDetailBean> callback, RequestBody body) {
        Call<OpinionSurveyProblemDetailBean> call = RetrofitManager.getInstance().getApiService().opinionSurveyProblemDetail(body);
        call.enqueue(callback);
    }

    //5.3民意调查结
//    Call<> getOpinionSurveyResult(@Body RequestBody body);
    public void getOpinionSurveyResult(Callback<CommonBean> callback, RequestBody body) {
        Call<CommonBean> call = RetrofitManager.getInstance().getApiService().getOpinionSurveyResult(body);
        call.enqueue(callback);
    }


    /**
     * 6 .楼宇运营
     */
    //6. 1运营楼宇初始页面展示数据
    public void getElectricMonthData(Callback<ElectricMonthDataBean> callback, RequestBody body) {
        Call<ElectricMonthDataBean> call = RetrofitManager.getInstance().getApiService().getElectricMonthData(body);
        call.enqueue(callback);
    }

    //6.2运营楼宇点击柱状图月份展示分项用电数据
    public void getElectricInformation(Callback<ElectricInformationBean> callback) {
        Call<ElectricInformationBean> call = RetrofitManager.getInstance().getApiService().getElectricInformation();
        call.enqueue(callback);
    }


    /**
     * 7.审核信息
     */
    //7. 1审核信息展示
    public void informQueryAll(Callback<AuditeInfoBean> callback, RequestBody body) {
        Call<AuditeInfoBean> call = RetrofitManager.getInstance().getApiService().informQueryAll(body);
        call.enqueue(callback);
    }

    // 7.2查看详情
    public void informGetDetails(Callback<AuditeInfoDetailBean> callback, RequestBody body) {
        Call<AuditeInfoDetailBean> call = RetrofitManager.getInstance().getApiService().informGetDetails(body);
        call.enqueue(callback);
    }

    //7.3接收信息----是否通过审核
    public void informGetCheckData(Callback<AuditeInfoCheckBean> callback, RequestBody body) {
        Call<AuditeInfoCheckBean> call = RetrofitManager.getInstance().getApiService().informGetCheckData(body);
        call.enqueue(callback);
    }

    /**
     * 8 故障信息
     */
    //8.1故障信息上报
    public void getRepairTrouble(Callback<RepairTroubleBean> callback, String type, String address, String description) {

        JSONObject params = new JSONObject();
        try {

            String userId = DataCache.getInstance().getUserMap().get(AppConstant.userId);

            params.put("id", userId);
            params.put("type", type);
            params.put("address", address);
            params.put("description", description);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                params.toString());

        Call<RepairTroubleBean> call = RetrofitManager.getInstance().getApiService().getRepairTrouble(requestBody);
        call.enqueue(callback);
    }

    //8.2报修跟踪
    public void getRepairTracking(Callback<RepairTrackingBean> callback) {

        JSONObject params = new JSONObject();
        try {

            params.put("pageNum", AppConstant.PAGE_NUMBER);
            params.put("pageSize", AppConstant.PAGE_SIZE);
            params.put("id", DataCache.getInstance().getUserMap().get(AppConstant.userId));

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                params.toString());

        Call<RepairTrackingBean> call = RetrofitManager.getInstance().getApiService().getRepairTracking(requestBody);
        call.enqueue(callback);
    }

    //8.3维修确认
    public void getRepairOk(Callback<CommonBean> callback, String repairId) {

        JSONObject params = new JSONObject();
        try {

            String userId = DataCache.getInstance().getUserMap().get(AppConstant.userId);

            params.put("repairId", repairId);
            params.put("userId", userId);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                params.toString());

        Call<CommonBean> call = RetrofitManager.getInstance().getApiService().getRepairOk(requestBody);
        call.enqueue(callback);
    }

    //8.4报修统计
    public void getRepairStatistics(Callback<RepairInfoBean> callback){

        JSONObject params = new JSONObject();
        try {

            params.put("pageNum", 1);
            params.put("pageSize", 20);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                params.toString());


        Call<RepairInfoBean> call = RetrofitManager.getInstance().getApiService().getRepairStatistics(requestBody);
        call.enqueue(callback);
    }

    //8.5设备维修详情（修改）
    public void getRepairParticulars(Callback<RepairDetailBean> callback, String repairId) {

        JSONObject params = new JSONObject();
        try {

            String userId = DataCache.getInstance().getUserMap().get(AppConstant.userId);

            params.put("repairId", repairId);
            params.put("userId", userId);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"),
                params.toString());

        Call<RepairDetailBean> call = RetrofitManager.getInstance().getApiService().getRepairParticulars(requestBody);
        call.enqueue(callback);
    }

    /**
     * 9 通知
     */

    //9.1查看所有通知
    public void getNotification(Callback<NotificationBean> callback, RequestBody body) {
        Call<NotificationBean> call = RetrofitManager.getInstance().getApiService().getNotification(body);
        call.enqueue(callback);
    }


    /**
     * 9 通知
     */

    //9.2查看一条通知内容
    /**
     * 根据“1.20查看所有通知”接口中的type来判定链接地址：
     *     目前一共三种类型：设备故障、调查问卷、下发通知
     *
     * 测试链接
     *     设备故障：“设备维修详情”接口的链接
     *     调查问卷：“民意调查填写”接口的链接
     *     下发通知： “查看下发通知详情”接口的链接
     *
     * TypeId改成相应的id名称
     */

    //9.3查看下发通知详情
    public void getNotificationDetails(Callback<NotificationDetailBean> callback, RequestBody body) {
        Call<NotificationDetailBean> call = RetrofitManager.getInstance().getApiService().getNotificationDetails(body);
        call.enqueue(callback);
    }


}
