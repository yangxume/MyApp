package com.xy.retrofit.bean;

import java.util.List;

/**
 * Copyright
 * <p>
 * Created by xuyang on 2019/1/26 13:49
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class OpinionSurveyProblemDetailBean {


    /**
     * result : [{"problem":"问题1","options":[{"option":"是"},{"option":"否"}],"problemId":149,"type":"radio"}]
     * code : 10000
     * aProblem : 1
     * problemNum : 1
     * errorMsg : 调查问卷问题信息获取成功
     */

    private int code;
    private int aProblem;
    private int problemNum;
    private String errorMsg;
    private List<ResultBean> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getAProblem() {
        return aProblem;
    }

    public void setAProblem(int aProblem) {
        this.aProblem = aProblem;
    }

    public int getProblemNum() {
        return problemNum;
    }

    public void setProblemNum(int problemNum) {
        this.problemNum = problemNum;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * problem : 问题1
         * options : [{"option":"是"},{"option":"否"}]
         * problemId : 149
         * type : radio
         */

        private String problem;
        private int problemId;
        private String type;
        private List<OptionsBean> options;

        public String getProblem() {
            return problem;
        }

        public void setProblem(String problem) {
            this.problem = problem;
        }

        public int getProblemId() {
            return problemId;
        }

        public void setProblemId(int problemId) {
            this.problemId = problemId;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<OptionsBean> getOptions() {
            return options;
        }

        public void setOptions(List<OptionsBean> options) {
            this.options = options;
        }

        public static class OptionsBean {
            /**
             * option : 是
             */

            private String option;

            public String getOption() {
                return option;
            }

            public void setOption(String option) {
                this.option = option;
            }
        }
    }
}
