package com.lifegame.common;

/**
 * 全局统一返回类
 */
public class Result<T> {

    /** 状态码: 200-成功, 500-服务器错误, 401-未授权 */
    private int code;

    /** 提示信息 */
    private String message;

    /** 业务数据 */
    private T data;

    private Result() {}

    private Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /** 成功返回（带数据） */
    public static <T> Result<T> success(T data) {
        return new Result<>(200, "success", data);
    }

    /** 成功返回（无数据） */
    public static <T> Result<T> success() {
        return new Result<>(200, "success", null);
    }

    /** 失败返回 */
    public static <T> Result<T> error(String message) {
        return new Result<>(500, message, null);
    }

    /** 自定义状态码返回 */
    public static <T> Result<T> of(int code, String message, T data) {
        return new Result<>(code, message, data);
    }

    public int getCode() { return code; }
    public void setCode(int code) { this.code = code; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}
