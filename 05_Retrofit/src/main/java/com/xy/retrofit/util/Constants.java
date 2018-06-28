package com.xy.retrofit.util;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/6/13 16:24
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class Constants {

    public static final String BASE_URL = "http://api.tianapi.com/";

    private static final String APIKEY = "5e7e112aedd1abce757f9903a219e214";

    private static final String end_url = "key="+APIKEY+"&num=";

    public static final String social = BASE_URL+"social/?"+end_url;//	社会新闻API接口服务
    public static final String guonei = BASE_URL+"guonei/?"+end_url;//	//国内新闻API接口服务
    public static final String world = BASE_URL+"world/?"+end_url;//	//国际新闻API接口服务
    public static final String huabian = BASE_URL+"huabian/?"+end_url;//	娱乐新闻、明星花边、探班、娱乐活动等
    public static final String tiyu = BASE_URL+"tiyu/?"+end_url;//	国内体育行业、体育明星动态等
    public static final String nba = BASE_URL+"nba/?"+end_url;//	NBA动态、篮球赛等
    public static final String football = BASE_URL+"football/?"+end_url;//	国足资讯、国足明星动态等
    public static final String keji = BASE_URL+"keji/?"+end_url;//	信息科技、数码科技、物理科技
    public static final String startup = BASE_URL+"startup/?"+end_url;//	互联网创业、创新、创业人物动态
    public static final String apple = BASE_URL+"apple/?"+end_url;//	Apple产品动态，果粉、教程帮助
    public static final String military = BASE_URL+"military/?"+end_url;//	军事资讯、军情动态、科技发展等
//    public static final String NEWS_SOCIAL = BASE_URL+"mobile/?"+end_url;//	移动互联网行业资讯
//    public static final String NEWS_SOCIAL = BASE_URL+"travel/?"+end_url;//	旅游、周边、景点
//    public static final String NEWS_SOCIAL = BASE_URL+"health/?"+end_url;//	健康知识、养生、中西医
//    public static final String NEWS_SOCIAL = BASE_URL+"qiwen/?"+end_url;//	世界奇闻、民间趣事、灵异事件等
//    public static final String NEWS_SOCIAL = BASE_URL+"meinv/?"+end_url;//	美女图片、大家都懂
//    public static final String NEWS_SOCIAL = BASE_URL+"vr/?"+end_url;//	VR虚拟现实相关新闻资讯
//    public static final String NEWS_SOCIAL = BASE_URL+"it/?"+end_url;//	IT行业相关新闻资讯

}
