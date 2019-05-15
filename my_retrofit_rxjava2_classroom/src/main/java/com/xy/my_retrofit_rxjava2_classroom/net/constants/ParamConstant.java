package com.xy.my_retrofit_rxjava2_classroom.net.constants;

/**
 * 参数常量
 * <p>
 * Created on 17/3/16.
 * author: yuanbaoyu
 */
public class ParamConstant {

    public static final String PARAM_UID = "uid";

    public static final String PARAM_TOKEN = "token";

    public static final String ECODE = "ecode";

    public static final String EMSG = "emsg";

    public static final String EXTRA = "extra";

    public static final String CLASS_ID = "class_id";

    public static final String PAGE = "page";

    public static final String TOKEN = "token";

    public static final String UID = "uid";

    public static final String COURSE_ID = "course_id";

    public static final String COLLECTION_ID = "collection_id";

    public static final String PUBLISH_ID = "publish_id";

    public static final String REASON = "reason";

    public static final String LIVE_STATUS = "zb_status";

    public static final String STATUS = "status";

    public static final String ORIGINAL_STATUS = "original_status";

    public static final String RESOURCE_ID = "resource_id";

    public static final String RESOURCEID = "resourceId";

    public static final String QUERY_OLD_QUIZ = "query_old_quiz";

    public static final String TYPE = "type";

    public static final String QUIZ_ID = "quiz_id";

    public static final String QUESTION_ID = "question_id";

    public static final String LINK_ID = "link_id";

    public static final String STATISTIC_TYPE = "statistic_type";

    public static final String PAGE_NO = "page_no";

    public static final String CONTENT = "content";

    public static final String KEY = "key";

    public static final String SCREEN = "screen";

    public static final String TIME = "time";

    public static final String STACK = "stack";

    public static final String TYPE_PUBLISH = "type_publish";

    public static final String SCENE_TYPE = "scene_type";

    public static final String LIST="list";

    public static final int CLASSROOM_EXERCISE_TYPE = 1;

    /**
     * 上课 长链接对应key
     */
    public static final String INTO_CLASS = "into_class";
    //上课
    public static final int DATA_START_CLASS_SOURCE = 1;
    //直播
    public static final int DATA_START_LIVE_SOURCE = 2;
    public static final int DATA_START_CLASS_TYPE = 1;
    public static final String SOURCE = "source";
    public static final String ROOM_ID = "room_id";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PARAM = "param";
    public static final String LIVEPARAM = "liveparam";
    public static final String ISLIVE = "islive";
    public static final String LIVESTARTTIME = "livestarttime";
    public static final String LIVEENDTIME = "liveendtime";

    public static final String IS_RECONNECT = "is_reconnect";
    public static final String ROOMID = "roomid";
    public static final String OPTYPE = "optype";
    public static final String CURRICULUMID = "curriculumId";

    /**
     * 上课 习题的常量 是否过滤
     */

    public static final String DATA_QUERY_OLD_QUIZ = "1";

    //同步习题
    public static final String DATA_RESCOURCE_EXERCISE = "1";
    // 作业
    public static final String DATA_RESCOURCE_HOMEWORK = "2";
    //测评
    public static final String DATA_RESCOURCE_ASSESSMENT = "3";


    //指定发送
    public static final int DATA_SOCKE_SEND_TYPE_ONE = 0;
    //发生广播
    public static final int DATA_SOCKE_SEND_TYPE_BROADCAST = 1;
    //发送接收者类型
    public static final int DATA_SOCKE_TARGET_TYPE_STUDENT = 0;
    public static final int DATA_SOCKE_TARGET_TYPE_TEACHER = 1;

    public static final String DATA_SOCKE_TARGET_TYPE = "target";


    //上课请求 答题状态
    public static final String CONNECTION_LINK_ID = "connection_link_id";

    /**
     * 上课  答题状态存储
     */
    public static final String TEACHER_ID = "teacher_id";

    public static final String RESULT = "result";

    public static final String CON = "result";

    /**
     * 上课资源类型
     */
    public static final int EXERCISE_TYPE_COMPOSITE = 1;

    public static final int EXERCISE_TYPE_SINGLE = 0;

    public static final String EXERCISE_CONNECTION_MODE = "connection_mode_";


    /**
     * 升级
     */
    public static final String APPS = "apps";
    public static final String APP = "app";
    public static final String VCODE = "vcode";
    public static final String SID = "sid";
    public static final String ORGTYPE = "orgtype";


    /**
     *  * 批改
     */
    /**
     * 小题的id
     */
    public static final String SUB_QUESTION_ID = "sub_question_id";

    public static final String STUDENT_ID = "student_id";

    public static final String STRUCT_ID = "struct_id";

    public static final String ANSWER = "answer";

    public static final String INDEX = "index";

    public static final String UPDATE_STATUS = "update_status";

    /**
     * 批注
     */
    public static final String ADD = "add";
    public static final String DELETE = "delete";
    public static final String VIEW_PARAM_PREVIOUS = "previous";
    public static final String JDT_ANSWER = "jdt_answer";
    public static final String POSTTL_ADD_SVG = "posttl_add_svg";
    public static final String POSTTL_DEL_SVG = "posttl_del_svg";
    public static final String POSTTL_PREV = "posttl_prev";
    public static final String JDT_MERGE_MD5 = "jdt_merge_md5";
    public static final String POSTTL_URL = "posttl_url";
    public static final String FILE_NAME = "fileName";

    /**
     * 微课 视频 清晰度
     */



    public static final int RESOURCETYPE_AUDIO = 4;
    public static final int RESOURCETYPE_VIDEO = 5;
    public static final String RESLIST = "resList";
    public static final String RESOURCETYPE = "resourceType";
    public static final String RESOLUTIONTYPE = "resolutionType";
    public static final String VIDEOURL = "videoUrl";
    public static final String FILESIZE = "fileSize";
    public static final String DURATION = "duration";

    //0流畅、1清晰、2高清、3试看
    public static final int  resolutionType_0 = 0;
    public static final int  resolutionType_1 = 1;
    public static final int  resolutionType_2 = 2;
    public static final int  resolutionType_3 = 3;

    public static final String resolutionType0 = "流畅";
    public static final String resolutionType1 = "清晰";
    public static final String resolutionType2 = "高清";
    public static final String resolutionType3 = "试看";


    public static final String ARCHITECTURE="architecture";
    public static final String COMMENT="comment";
    public static final String CONTEXT="context";
    public static final String SCORE="score";
    public static final String SENTENCE="sentence";
    public static final String VOCABULARY="vocabulary";


}
