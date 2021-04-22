package com.hospital.managementsystem.exception;


import static com.hospital.managementsystem.enums.Status.REQUEST_PARAMS_NOT_VALID_ERROR;

/**
 * @ClassName: ParamValidException
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/7 8:27 下午
 * @Version: 1.0
 */
public class ParamValidException extends BaseException {

    private int code = REQUEST_PARAMS_NOT_VALID_ERROR.getCode();

    public ParamValidException(String msg) {
        super(msg);
    }

    public ParamValidException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
