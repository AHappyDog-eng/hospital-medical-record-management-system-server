package com.hospital.managementsystem.enums;

/**
 * @ClassName: Status
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/2 8:51 下午
 * @Version: 1.0
 */
public enum Status {

    SUCCESS(0, "成功"),

    /**1xxxx业务领域错误*/
    UNKNOWN_ERROR(10001, "未知错误"),
    BUSINESS_ERROR(10002, "业务错误"),

    /**2xxxx授权领域错误*/
    USERNAME_AND_PASSWORD_ERROR(20001, "用户名和密码错误"),
    USER_LOGIN_FAILURE(20002, "用户登录失败"),
    USER_ENABLE_OR_DISABLE_ERROR(20003, "启用/禁止失败"),
    USER_UPDATE_ERROR(20004, "更新用户失败"),
    AUTH_FAILURE(20005, "权限验证失败"),
    AUTH_FAILURE_USER(20006, "用户已禁用"),
    USER_NOT_EXIST_ERROR(20007, "用户不存在"),
    USER_EXIST_ERROR(20007, "用户已存在"),
    USER_REGIST_FAILURE(20008,"用户注册失败"),
    /**3xxxx 中间件领域错误*/
    /**30001-30100 ES*/
    NO_SUCH_INDEX_ERROR(30001, "索引未建立"),
    GET_INDEX_NAME_ERROR(30002, "无法获取索引名称"),
    INDEX_FIELD_UN_CATEGORIZED_ERROR(30003, "索引字段类型未识别"),

    /**30101-30200 工作清单*/
    JOB_ALREADY_EXIST_ERROR(30101, "这个岗位已经存在,不需要重新发布"),
    JOB_NOT_EXIST_ERROR(30102,"此岗位已经不存在，不需要再次删除"),

    /**4xxxx 参数校验领域*/
    /**短信业务*/
    SMS_SEND_ORROR(40000,"短信发送失败，请重试"),
    SMS_PHONE_SEND_ORROR(40009,"该手机号多次请求，请一分钟后重试"),
    REQUEST_PARAMS_NOT_VALID_ERROR(40001, "请求参数验证不通过"),
    KAFKA_SERVER_ADDRESS_ERROR(40002, "kafka服务端地址不正确"),
    RESOURCE_SIZE_EXCEED_LIMIT(40003, "上传资源超过限制大小"),
    UN_SUPPORT_MEDIA_TYPE_HEADER(40004, "该HTTP请求头不支持"),
    ID_CHECK_NO_PASS_ERROR(40005, "此ID校验不通过"),
    LICENSE_FILE_SUFFIX_ERROR(40006, "许可文件后缀名错误"),
    UN_SUPPORT_HTTP_METHOD_HEADER(40007, "该HTTP请求方法不支持"),
    TASK_CAN_NOT_BE_NULL_ERROR(40008, "任务类型参数不能为空"),
    ;


    private int code;
    private String msg;

    private Status(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
