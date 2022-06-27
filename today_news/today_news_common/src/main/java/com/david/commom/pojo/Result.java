package com.david.commom.pojo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Result<T> implements Serializable {
    @ApiModelProperty(notes = "return error message", required = true)
    private String message;
    @ApiModelProperty(notes = "return status code,2000X -> successful,4000X -> error，5000X -> server error", required = true)
    private Integer code;
    @ApiModelProperty(notes = "returned data", required = true)
    private T data;

    //successful, nothing to return
    public static <T> Result<T> ok() {
        return new Result<T>(StatusCode.SUCCESS.message(), StatusCode.SUCCESS.code(), null);
    }

    //successful and return with data
    public static <T> Result<T> ok(T data) {
        return new Result<T>(StatusCode.SUCCESS.message(), StatusCode.SUCCESS.code(), data);
    }

    //system error, nothing to return
    public static <T> Result<T> error() {
        return new Result<T>(StatusCode.FAILURE.message(), StatusCode.FAILURE.code(), null);
    }

    //system error, return with data
    public static <T> Result<T> error(T data) {
        return new Result<T>(StatusCode.FAILURE.message(), StatusCode.FAILURE.code(), data);
    }

    //system error, return with status code and data
    public static <T> Result<T> error(StatusCode statusCode, T data) {
        return new Result<T>(statusCode.message(), statusCode.code(), data);
    }

    //system error, with nothing to return
    public static <T> Result<T> error(StatusCode statusCode) {
        return new Result<T>(statusCode.message(), statusCode.code(), null);
    }

    //self defined error message, code and data
    public static <T> Result<T> errorMessage(String message, Integer code, T data) {
        return new Result<T>(message, code, data);
    }
    //self defined error message
    public static <T> Result<T> errorMessage(String message) {
        return new Result<T>(message, StatusCode.CUSTOM_FAILURE.code(), null);
    }
}
