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

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by dell on 2018/5/14.
 */
public interface ApiService {

    @GET("10/1")
    Call<MyTest> getData();


    /**
     * 2 登录
     */
    @POST("login/json")
    Call<LoginBean>  getLogin(@Body RequestBody body);

    @GET("logout")
    Call<LogoutBean> getLogout();

    /**
     * 3 天气
     */
    @GET("weather/get")
    Call<WeatherBean> getWeather();


    /***
     * 4.用户、一卡通
     */
    //    4.1用户信息
    @GET("user/get")
    Call<UserInfoBean> getUserInfo();


    //    4.2消费信息
    @POST("consume/get")
    Call<UserConsumptionBean> getConsumption(@Body RequestBody body);

    //    4.3一卡通信息
    @GET("card/get")
    Call<CardInfoBean> getCard();

    //    4.4充值信息
    @POST("recharge/get")
    Call<UserReChargeBean> getRecharge(@Body RequestBody body);
//    http://www.zgaiss.club:8080/mengxi/app/recharge/get

    //    4.5持卡人基本信息
    @GET("app/get")
    Call<CardUserinfoBean> getCardUserinfo();




    /**
     * 5 民意调查
     */
    //5.1民意调查列表
    @POST("paper/answer/list")
    Call<OpinionSurveyBean> getOpinionSurvey(@Body RequestBody body);

    //5.2民意调查填写
    @POST("paper/answer/view")
    Call<OpinionSurveyProblemDetailBean> opinionSurveyProblemDetail(@Body RequestBody body);

    //5.3民意调查结
    @POST("paper/answer")
    Call<CommonBean> getOpinionSurveyResult(@Body RequestBody body);


    /**
     * 6 .楼宇运营
     */
    //6. 1运营楼宇初始页面展示数据
    @POST("buildingOperate/electricInformation")
    Call<ElectricInformationBean> getElectricInformation();

    //6.2运营楼宇点击柱状图月份展示分项用电数据
    @POST("buildingOperate/getElectricMonthData")
    Call<ElectricMonthDataBean> getElectricMonthData(@Body RequestBody requestBody);


    /**
     * 7.审核信息
     */
    //7. 1审核信息展示
    @POST("inform/get")
    Call<AuditeInfoBean> informQueryAll(@Body RequestBody requestBody);

    // 7.2查看详情
    @POST("inform/getDetails")
    Call<AuditeInfoDetailBean> informGetDetails(@Body RequestBody requestBody);

    //7.3接收信息----是否通过审核
    @POST("inform/getCheckData")
    Call<AuditeInfoCheckBean> informGetCheckData(@Body RequestBody requestBody);



    /**
     * 8 故障信息
     */
    //8.1故障信息上报
    @POST("repair/getRepairTrouble")
    Call<RepairTroubleBean> getRepairTrouble(@Body RequestBody requestBody);


    //8.2报修跟踪
    @POST("repair/getRepairTracking")
    Call<RepairTrackingBean> getRepairTracking(@Body RequestBody requestBody);


    //8.3维修确认
    @POST("repair/getOK")
    Call<CommonBean> getRepairOk(@Body RequestBody requestBody);

    //8.4报修统计
    @POST("repair/getRepairStatistics")
    Call<RepairInfoBean> getRepairStatistics(@Body RequestBody requestBody);

    //8.5设备维修详情（修改）
    @POST("repair/getRepairParticulars")
    Call<RepairDetailBean> getRepairParticulars(@Body RequestBody requestBody);


    /**
     * 9 通知
     */

    //9.1查看所有通知
    @POST("notification/get")
    Call<NotificationBean> getNotification(@Body RequestBody requestBody);

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
    @POST("notification/getNotifi")
    Call<NotificationDetailBean> getNotificationDetails(@Body RequestBody requestBody);


}
