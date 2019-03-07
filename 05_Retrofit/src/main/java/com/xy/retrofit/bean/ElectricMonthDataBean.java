package com.xy.retrofit.bean;

import java.util.List;

/**
 * Copyright
 * <p>
 * Created by xuyang on 2019/1/26 13:56
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class ElectricMonthDataBean {


    /**
     * code : 10000
     * subItemData : [{"num":12830,"type":"备用"},{"num":6418,"type":"动力用电"},{"num":6842,"type":"空调用电"},{"num":10586,"type":"瞬时功率"},{"num":8196,"type":"特殊用电"},{"num":7000,"type":"照明插座用电"}]
     * errorMsg : 运营楼宇点击月份分项用电展示信息成功
     */

    private int code;
    private String errorMsg;
    private List<ElectricInformationBean.SubItemDataBean> subItemData;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ElectricInformationBean.SubItemDataBean> getSubItemData() {
        return subItemData;
    }

    public void setSubItemData(List<ElectricInformationBean.SubItemDataBean> subItemData) {
        this.subItemData = subItemData;
    }


}
