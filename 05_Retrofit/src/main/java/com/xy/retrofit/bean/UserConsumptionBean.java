package com.xy.retrofit.bean;

import java.util.List;

/**
 * Created by dell on 2018/6/25.
 */
public class UserConsumptionBean {


    /**
     * total : 2
     * code : 10000
     * pages : 1
     * errorMsg : consume信息获取成功
     * consumes : [{"id":6,"name":"name1","preson_num":"001","car_num":"0001","num":"1","time":"2018-12-29 11:11:11","money":100,"have":900}]
     */

    private int total;
    private int code;
    private int pages;
    private String errorMsg;
    private List<ConsumesBean> consumes;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ConsumesBean> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<ConsumesBean> consumes) {
        this.consumes = consumes;
    }

    public static class ConsumesBean {
        /**
         * id : 6
         * name : name1
         * preson_num : 001
         * car_num : 0001
         * num : 1
         * time : 2018-12-29 11:11:11
         * money : 100
         * have : 900
         */

        private int id;
        private String name;
        private String preson_num;
        private String car_num;
        private String num;
        private String time;
        private int money;
        private int have;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPreson_num() {
            return preson_num;
        }

        public void setPreson_num(String preson_num) {
            this.preson_num = preson_num;
        }

        public String getCar_num() {
            return car_num;
        }

        public void setCar_num(String car_num) {
            this.car_num = car_num;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getHave() {
            return have;
        }

        public void setHave(int have) {
            this.have = have;
        }
    }
}
