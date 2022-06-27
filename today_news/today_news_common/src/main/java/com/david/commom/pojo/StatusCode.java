package com.david.commom.pojo;

public enum StatusCode {
    SUCCESS(20000, "operation successful"),
    PARAM_ERROR(40000, "error with parameter varible"),
    NOT_FOUND(40004, "resource cannot be found"),
    FAILURE(50000, "system error"),
    CUSTOM_FAILURE(50001, "self-defined error");
    private final Integer code;

    private final String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    //get status code
    public Integer code() {
        return code;
    }

    //get message
    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
