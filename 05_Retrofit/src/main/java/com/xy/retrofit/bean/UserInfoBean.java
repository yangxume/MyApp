package com.xy.retrofit.bean;

import java.util.List;

/**
 * Created by dell on 2018/6/21.
 */
public class UserInfoBean {


    /**
     * code : 10000
     * user : [{"id":2,"username":"admin","password":"43442676c74ae59f219c2d87fd6bad52","sex":"男","department":"保安部","userType":"app","job":"保安","realname":"admin","phone":"13366851236","createdAt":"2019-01-02 15:16:00","updatedAt":"2019-01-26 12:58:00","cardId":1}]
     * errorMsg : 用户信息获取成功
     */

    private int code;
    private String errorMsg;
    private List<UserBean> user;

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

    public List<UserBean> getUser() {
        return user;
    }

    public void setUser(List<UserBean> user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 2
         * username : admin
         * password : 43442676c74ae59f219c2d87fd6bad52
         * sex : 男
         * department : 保安部
         * userType : app
         * job : 保安
         * realname : admin
         * phone : 13366851236
         * createdAt : 2019-01-02 15:16:00
         * updatedAt : 2019-01-26 12:58:00
         * cardId : 1
         */

        private int id;
        private String username;
        private String password;
        private String sex;
        private String department;
        private String userType;
        private String job;
        private String realname;
        private String phone;
        private String createdAt;
        private String updatedAt;
        private int cardId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getCardId() {
            return cardId;
        }

        public void setCardId(int cardId) {
            this.cardId = cardId;
        }
    }
}
