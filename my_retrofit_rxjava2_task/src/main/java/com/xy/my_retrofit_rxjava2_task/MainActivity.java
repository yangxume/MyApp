package com.xy.my_retrofit_rxjava2_task;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xy.my_retrofit_rxjava2_task.network.DataController;
import com.xy.my_retrofit_rxjava2_task.network.NetResponse;
import com.xy.my_retrofit_rxjava2_task.network.model.base.BaseBean;
import com.xy.my_retrofit_rxjava2_task.network.model.request.RequestTaskList;
import com.xy.my_retrofit_rxjava2_task.network.model.response.ResultTaskList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestTaskList requestTaskList = new RequestTaskList();

        DataController.getInstance(null)
                .taskList(new NetResponse<ResultTaskList>(){
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(BaseBean<ResultTaskList> data) {

            }

            @Override
            public void onCompleted() {

            }
        },requestTaskList);
    }
}
