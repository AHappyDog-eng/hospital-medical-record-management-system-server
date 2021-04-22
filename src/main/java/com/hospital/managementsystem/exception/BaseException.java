package com.hospital.managementsystem.exception;

/**
 * @ClassName: BaseException
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/7 9:51 下午
 * @Version: 1.0
 */
public class BaseException extends RuntimeException {
    protected int code;
    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(int code, String msg) {
        super(msg);
        this.code = code;

    }
}
