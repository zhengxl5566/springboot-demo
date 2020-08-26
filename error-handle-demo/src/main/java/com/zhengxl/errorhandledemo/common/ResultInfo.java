package com.zhengxl.errorhandledemo.common;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @description: 封装返回结果
 * @projectName:validation-demo
 * @see:com.zhengxl.validationdemo.controller
 * @author:郑晓龙
 * @createTime:2020/7/24 17:32
 * @version:1.0
 */
public class ResultInfo<T> implements Serializable {

    private static final long serialVersionUID = 6793350277616007958L;

    private Integer status;
    private String message;
    private T response;

    public ResultInfo success() {
        this.status = HttpStatus.OK.value();
        this.message = "OK";
        return this;
    }

    public ResultInfo success(Integer status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }

    public ResultInfo<T> success(T response) {
        this.status = HttpStatus.OK.value();
        this.message = "OK";
        this.response = response;
        return this;
    }

    public ResultInfo<T> success(Integer status, String message, T response) {
        this.status = status;
        this.message = message;
        this.response = response;
        return this;
    }

    public ResultInfo error(String message) {
        this.status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.message = message;
        return this;
    }

    public ResultInfo error(Integer status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}

