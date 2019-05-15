package com.xy.my_retrofit_rxjava2_task.common;

/**
 * <pre>
 *     author : per4j
 *     e-mail : zhangpanzhao@okay.cn
 *     time   : 2018/05/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class BaseCorrectState {

    //    1对 2错，5半对，6未批，7无答案

    public static final int RIGHT = 1;  //对
    public static final int WRONG = 2;  //错
    public static final int HALFRIGHT = 5;  //半对
    public static final int UNCORRECT = 6;  //未批
    public static final int NO_ANSWER = 7; // 无答案

    public static int getScore(int status, int score) {
        int result = -1;
        switch (status) {
            case RIGHT:
                result = score;
                break;

            case WRONG:
                result = 0;
                break;

            case HALFRIGHT:
                result = ((int)(score * 0.5));
                break;

            case UNCORRECT:
                result = -1;
                break;

            default:
                result = -1;
                break;
        }
        return result;
    }
}
