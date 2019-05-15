package com.xy.my_retrofit_rxjava2_task.common;

/**
 * Created by ZDD.
 */
public class Constant {
    public static final int BASIC_NUMBER = 0x0A000;

    public static final int NORMAL_ZERO = 0;

    public static final int NEGATIVE_ONE = -1;
    public static final int NEGATIVE_TWO = -2;
    public static final int NEGATIVE_THREE = -3;
    public static final int NEGATIVE_FOUR = -4;
    public static final int NEGATIVE_FIVE = -5;
    public static final int NEGATIVE_SIX = -6;
    public static final int NEGATIVE_SEVEN = -7;
    public static final int NEGATIVE_EIGHT = -8;
    public static final int NEGATIVE_NINE = -9;
    public static final int NEGATIVE_TEN = -10;


    public static final int NUMBER_ONE = 1;
    public static final int NUMBER_TWO = 2;
    public static final int NUMBER_THREE = 3;
    public static final int NUMBER_FOUR = 4;
    public static final int NUMBER_FIVE = 5;
    public static final int NUMBER_SIX = 6;
    public static final int NUMBER_SEVEN = 7;
    public static final int NUMBER_EIGHT = 8;
    public static final int NUMBER_NINE = 9;
    public static final int NUMBER_TEN = 10;

    public static final int MSG_DOWNTIME_START = NUMBER_ONE;
    public static final int MSG_DOWNTIME_PAUSE = NUMBER_TWO;
    public static final int MSG_UPTIME_START = NUMBER_THREE;
    public static final int MSG_UPTIME_PAUSE = NUMBER_FOUR;

    public static final int PERMISSION_STORAGE_REQUEST_CODE = BASIC_NUMBER + NUMBER_ONE;
    public static final int PERMISSION_CAMERA_REQUEST_CODE = BASIC_NUMBER + NUMBER_TWO;
    public static final int PERMISSION_SENSORS_REQUEST_CODE = BASIC_NUMBER + NUMBER_THREE;
    public static final int PERMISSION_PHONE_REQUEST_CODE = BASIC_NUMBER + NUMBER_FOUR;
    public static final int PERMISSION_SMS_REQUEST_CODE = BASIC_NUMBER + NUMBER_FIVE;
    public static final int PERMISSION_CONTACTS_REQUEST_CODE = BASIC_NUMBER + NUMBER_SIX;
    public static final int PERMISSION_CALENDAR_REQUEST_CODE = BASIC_NUMBER + NUMBER_SEVEN;
    public static final int PERMISSION_LOCATION_REQUEST_CODE = BASIC_NUMBER + NUMBER_EIGHT;
    public static final int PERMISSION_MICROPHONE_REQUEST_CODE = BASIC_NUMBER + NUMBER_NINE;

    public static final String NEW_APK_NAME = "newApk.apk";
    public static final String PATCH_NAME = "apk.patch";

    public static final int INK_VIEW = NEGATIVE_ONE;
    public static final int MAIN_VIEW = NUMBER_ONE;

    /**
     * 报告相关
     */
    public static final String VIEW_ID = "view_id";
    public static final String VIEW_INIT = "view_init"; //view的初始化
    public static final String VIEW_PREVIEW = "view_preview"; //view的预览
    public static final String VIEW_UPDATE = "VIEW_UPDATE"; //view的更新
    public static final String VIEW_UNCLICK = "VIEW_UNCLICK"; //view不可点击
    public static final String VIEW_SCROLL = "VIEW_SCROLL"; //view的滑动
    public static final String VIEW_CLICK = "view_click"; //view的点击事件
    public static final String VIEW_ITEM_CLICK = "VIEW_ITEM_CLICK"; //view item的点击事件
    public static final String REPORT_Q_INDEX_TYPE = "q_index_type";
    public static final String QUESTION_NEXT_ID = "question_next_id";
    public static final String REPORT_Q_ACCURACY = "q_accuracy";
    public static final String REPORT_ACCURACY_SHOW = "show_correct_flag";
    public static final String REPORT_BACK = "report_back";
    public static final String REPORT_QUERY = "REPORT_QUERY";
    public static final String TITLE_CHANGE = "TITLE_CHANGE";
    /**
     * 资源对应类型
     * video audio pic word ppt simul(同步习题)，ppt和pptx，doc和docx都写成ppt和word
     */
    public static final String RESOURCES_FILE_TYPE_PPT = "PPT";
    public static final String RESOURCES_FILE_TYPE_PPTX = "pptx";
    public static final String RESOURCES_FILE_TYPE_WORD = "word";
    public static final String RESOURCES_FILE_TYPE_VIDEO = "video";
    public static final String RESOURCES_FILE_TYPE_AUDIO = "audio";
    public static final String RESOURCES_FILE_TYPE_SIUML = "simul";
    public static final String RESOURCES_FILE_TYPE_PDF = "pdf";
    public static final String RESOURCES_FILE_TYPE_PICTURE = "pic";
    public static final String RESOURCES_FILE_TYPE_MICROVIDEO = "MICROVIDEO";//微课
    public static final String RESOURCES_FILE_TYPE_EXCEL = "excel";


    public static final String RESOURCE_KIND = "resource_kind";
    public static final String RESOURCE_NAME = "resource_name";

    public static final String REPORT_TOTAL_CLOSE = "REPORT_TOTAL_CLOSE";
    public static final String TASK_CLOSE = "TASK_CLOSE";
    public static final String REPORT_QUESTION = "REPORT_QUESTION";
    public static final String REPORT_GENERAL_DETAILS = "report_general_details";
    public static final String QUESTION_RESULT_JUMP = "jump_task_result";//内部向外部传题
    public static final String QUESTION_JUMP_DOWN_RESULT = "jump_down_task_result";//外部向内部传递切换信息的返回成功或失败
    public static final String QUESTION_JUMP = "jump";//外部向内部传递返回题的信息
    public static final String QUESTION_JUMP_DOWN = "jump_down";//外部向内部传递切换信息返回成功或者失败

    public static final String QUESTION_RESULT_BUILD = "build_result";//构建反馈
    public static final String INK_ANSWER_SCROLL = "answer_scroll";//ink屏answer滚动
    public static final String TYPE_QUESTION = "TYPE_QUESTION";
    public static final String TYPE_PEOPLE = "TYPE_PEOPLE";
    public static final String TYPE = "TYPE";
    public static final String QUESTION_NUM = "QUESTION_NUM";
    public static final String STUDENT_NUM = "STUDENT_NUM";
    public static final String CURRENT_NUM = "CURRENT_NUM";
    public static final String STUDENT_TOTAL = "STUDENT_TOTAL";
    public static final String STUDENT_PORTRAIT = "STUDENT_PORTRAIT";//学生头像
    public static final String STUDENT_NAME = "STUDENT_NAME";//学生姓名
    public static final String STUDENT_ID = "STUDENT_ID";//学生ID
    public static final String REPORT_CORRECT_RESULT = "REPORT_CORRECT_RESULT";//报告页的正确错误结果
    public static final String STUDENT = "STUDENT";//学生
    public static final String QUESTION = "QUESTION";//题目
    public static final String QUESTION_ID = "QUESTION_ID";//题目ID
    public static final String SUB_QUESTION_ID = "SUB_QUESTION_ID";//复合小题目ID
    public static final String REPORT_UNSELECT = "REPORT_UNSELECT";//无学生时不可查看报告
    public static final String TYPE_UNSELECT = "TYPE_UNSELECT";//无学生时不可选择查询类型
    public static final String DISCERN_RESULT = "DISCERN_RESULT";//手势识别结果
    public static final String MODIFY_CLEVER = "MODIFY_DISCERN_RESULT_CLEVER";//智能批改
    public static final String REMOVE_SPOKEN_HINT = "REMOVE_SPOKEN_HINT";//移除听口题提示语
    public static final String MODIFY_USER = "MODIFY_USER";//手动批改
    public static final String POSTIL_USER = "POSTIL_USER";//批注


    public static final String REPORT_VIEW_TYPE_Q_TITLE = "3";
    public static final String REPORT_VIEW_TYPE_CHOOSEITEM = "4";
    public static final String REPORT_VIEW_TYPE_COMPOSITE_PROBLEM_ITEM = "5";

    /**
     * 投屏相关
     */
    public static final String PROJECTION_CLOSE = "PROJECTION_CLOSE";

    /**
     * 报告教师批改结果
     */
    public static final String CORRECT_RESULT = "CORRECT_RESULT";

    /**
     * 点击报告右上角关闭按钮时发送的属性名称
     */
    public static final String REPORT_CONTENT_CLOSE = "REPORT_CONTENT_CLOSE";

    /**
     * 获取作答情况－优秀率
     */
    public static final String REPORT_Q_EXCELLENCE = "report_q_excellence";
    /**
     * 是否智能批注
     */
    public static final String REPORT_INTELLIGENT = "intelligent";

    /**
     * 题是否已停用
     */
    public static final String REPORT_DEACTIVATE = "report_deactivate";

    /**
     * 点击报告弹出层底部按钮时发送的属性名称
     */
    public static final String REPORT_BOTTOM_CLOSE = "REPORT_BOTTOM_CLOSE";
    public static final String REPORT_HIDE_LEFT = "REPORT_HIDE_LEFT";

    /**
     * 三指投屏打点
     */
    String TEACHER_ID = "teacherId";
    String ACTION = "action";
    String SCENE = "scene";

    /**
     * 题库没有对应的类型
     */
    public static final int TYPE_NONE = -1;

    /**
     * 听口题添加：1、只有正确率，2只有优秀率，3都有
     */
    public static final String TASK_REPORT_QTYPE_FLAG = "task_report_qtype_flag";


    /**
     * view数据里标示是否是听口题
     */
    public static final int KIND_TINGKOU = 1; //标示是听口题
    public static final int KIND_UN_TINGKOU = 0;//标示非听口题

    /**
     * 批改角色
     */
    public static class PosttlRole {

        public static final String POSTTL_ROLE_TEACHER = "teacher"; // 教师
        public static final String POSTTL_ROLE_AI = "ai"; // 智批
        public static final String POSTTL_ROLE_STUDENT = "student"; // 学生
    }

    /**
     * 微课 视频 清晰度
     */

    public static final String VIDEOURL = "videoUrl";
    public static final int RESOURCETYPE_AUDIO = 4;
    public static final int RESOURCETYPE_VIDEO = 5;
    public static final String RESOURCE_TYPE = "resourceType";
    public static final String RESOLUTIONTYPE = "resolutionType";

    //0流畅、1清晰、2高清、3试看
    public static final int resolutionType_0 = 0;
    public static final int resolutionType_1 = 1;
    public static final int resolutionType_2 = 2;
    public static final int resolutionType_3 = 3;

    public static final String resolutionType0 = "流畅";
    public static final String resolutionType1 = "清晰";
    public static final String resolutionType2 = "高清";
    public static final String resolutionType3 = "试看";

    public static final String DISMISS_REPORT_SPINNER = "dismiss_report_spinner";


    public static final int TASK_NORMAL = 1;//正常的任务
    public static final int TASK_OVERDUE =2;//过期的任务
    public static final int TASK_OVERDUE_FIRST = -2;//过期的第二个

    public static final int TASK_SEARCH_TAB_ID=99;//搜索tab id

    public static final String TASK_SEARCH_BUILDER="TaskSearchBuilder";

}
