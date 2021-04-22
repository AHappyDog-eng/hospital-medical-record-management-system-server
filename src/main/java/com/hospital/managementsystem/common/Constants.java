package com.hospital.managementsystem.common;


/**
 * @ClassName: Constants
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/2 8:54 下午
 * @Version: 1.0
 */
public class Constants {

    public static final String SUCCESS = "success";

    public static final Integer SMS_EXPRISE = 60;
    public static final Integer TOKEN_EXPRISE = 60*30;

    public static final String FIX_TOKEN = "user.token.";
    /**
     * status
     */
    public static final String STATUS = "status";

    /**
     * message
     */
    public static final String MSG = "msg";


    /**
     * page size
     * 每页数据条数
     */
    public static final String PAGE_SIZE = "pageSize";

    /**
     * current page no
     * 当前页码
     */
    public static final String PAGE_NUMBER = "pageNo";

    /**
     * result
     */
    public static final String RESULT = "result";

    /**
     *
     */
    public static final String DATA_LIST = "data";

    public static final String TOTAL_LIST = "totalList";

    public static final String CURRENT_PAGE = "currentPage";

    public static final String TOTAL_PAGE = "totalPage";

    public static final String TOTAL = "total";

    /**
     * http header
     */
    public static final String HTTP_HEADER_UNKNOWN = "unKnown";

    /**
     * http X-Forwarded-For
     */
    public static final String HTTP_X_FORWARDED_FOR = "X-Forwarded-For";

    /**
     * http X-Real-IP
     */
    public static final String HTTP_X_REAL_IP = "X-Real-IP";

    /**
     * UTF-8
     */
    public static final String UTF_8 = "UTF-8";

    /**
     * comma ,
     */
    public static final String COMMA = ",";

    /**
     * COLON :
     */
    public static final String COLON = ":";

    public static final String POINT = ".";

    public static final String ASSERT_VALID = "AssertValid";


    public static final String ENGINE_GROUP_NAME_AND_GROUP_SMS = "^[0-9]{1,11}$";
    public static final String ENGINE_GROUP_NAME_AND_GROUP_PASS = "^[A-Za-z0-9_@!?.]{1,16}$";

    public static final String PREFIX_LOGIN = "login_";
    public static final String PREFIX_RES = "res_";
    public static final String SUFFIX_CODE = "_code";

    public static final String PHONE_PATTERN = "^1[3456789]\\d{9}$";

}
