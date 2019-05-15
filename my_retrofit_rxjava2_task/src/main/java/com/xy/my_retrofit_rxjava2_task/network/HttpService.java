package com.xy.my_retrofit_rxjava2_task.network;

import com.xy.my_retrofit_rxjava2_task.network.model.base.BaseBean;
import com.xy.my_retrofit_rxjava2_task.network.model.request.RequestTaskList;
import com.xy.my_retrofit_rxjava2_task.network.model.response.ResultTaskList;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * desc:HttpService
 *
 * @author zhaodongdong
 * QQ: 97966693
 * email: androidmdeveloper@163.com
 */
public interface HttpService {
    //任务列表
    @POST("api/t_pad/task/publish_list")
    Observable<BaseBean<ResultTaskList>> taskList(@Body RequestTaskList list);

}
