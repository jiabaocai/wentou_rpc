package com.bwtservice.util;

import lombok.Data;

/**
 * 返回接口工具类
 * @param <T>
 */
@Data
public class BaseResult<T> {
    private int code;
    private String msg;
    private T data;


    public BaseResult(Integer status, String msg, T data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult(T data) {
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    public BaseResult() {
        this.code = 200;
        this.msg = "success";
        this.data = null;
    }

    public static <T> BaseResult<T> success(T data) {
        return new BaseResult<T>(data);
    }

    public static <T> BaseResult<T> successNull() {
        return new BaseResult<T>();
    }

    public static <T> BaseResult<T> error(T data) {
        return new BaseResult<T>(0, "error", data);
    }

}
