package com.hhx.common.constants;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

/**
 * 统一Http返回Body
 */
@Getter
@NoArgsConstructor
public class ResponseData<T> {

    /**
     * 返回数据
     */
    private T data;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 错误码
     */
    private Integer status;

    /**
     * 错误提示信息
     */
    private String message;

    /**
     * 返回时间戳
     */
    private BigInteger timestamp = BigInteger.valueOf(System.currentTimeMillis());

    private ResponseData(T data, Boolean success, Integer status, String message) {
        this.data = data;
        this.success = success;
        this.status = status;
        this.message = message;
    }

    public static <T> ResponseData<T> data(T data) {
        return new ResponseData<>(data, true, null, null);
    }

    public static <T> ResponseData<T> success() {
        return new ResponseData<>(null, true, 200, null);
    }

    public static <T> ResponseData<T> error() {
        return new ResponseData<>(null, false, 200, null);
    }

    public static <T> ResponseData<T> error(Error error) {
        return new ResponseData<>(null, false, error.getCode(), error.name());
    }

    public static <T> ResponseData<T> error(T data, Error error) {
        return new ResponseData<>(data, false, error.getCode(), error.name());
    }

    public static <T> ResponseData<T> error(Error error, String msg) {
        return new ResponseData<>(null, false, error.getCode(), msg);
    }

    public static <T> ResponseData<T> error(int code, String msg) {
        return new ResponseData<>(null, false, code, msg);
    }
}
