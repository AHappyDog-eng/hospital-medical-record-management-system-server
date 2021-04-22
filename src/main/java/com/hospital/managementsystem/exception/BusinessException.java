package com.hospital.managementsystem.exception;

/**
 * @ClassName: BusinessException
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/7 9:51 下午
 * @Version: 1.0
 */
public class BusinessException extends BaseException {

    public BusinessException(String msg){super(msg);}

    public BusinessException(int code, String msg) {
        super(code, msg);

    }

    public Integer getCode() {
        return this.code;
    }

}
