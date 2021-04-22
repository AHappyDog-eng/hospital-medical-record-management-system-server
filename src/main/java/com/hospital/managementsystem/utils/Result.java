package com.hospital.managementsystem.utils;


import com.hospital.managementsystem.enums.Status;

import java.io.Serializable;

/**
 * @ClassName: Result
 * @Description:
 * @Author: jianghuiyun
 * @Date: 2020/9/2 8:39 下午
 * @Version: 1.0
 */
public class Result<T> implements Serializable {

    /**
     * status
     * 状态码
     */
    private Integer code;

    /**
     * message
     * 消息
     */
    private String msg;

    /**
     * data
     */
    private T data;

    public Result(){}

    public Result(Integer code , String msg){
        this.code = code;
        this.msg = msg;
    }
    public Result(Status status){
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Status{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
