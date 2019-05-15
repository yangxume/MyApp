package com.xy.my_retrofit_rxjava2_task.common;

import com.google.gson.JsonArray;
import com.xy.my_retrofit_rxjava2_task.network.model.response.ResultQReport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shiyan on 2018/3/26.
 */

public class CorrectProgressBean {
    /**
     * correct=2、7；错误和为提交学生信息集合
     */
    List<ResultQReport.SStatistics> errorStudent;
    JsonArray items1;
    /**
     * 正确率
     */
    public float rightRate = 0.0f;
    /**
     * 错误率
     */
    public float wrongRate = 0.0f;
    /**
     * 半对半错率
     */
    public float halfRate = 0.0f;
    /**
     * 未批改率
     */
    public float unCorrectRate = 0.0f;

    public CorrectProgressBean() {
        errorStudent = new ArrayList<>();
        items1 = new JsonArray();
    }
}
