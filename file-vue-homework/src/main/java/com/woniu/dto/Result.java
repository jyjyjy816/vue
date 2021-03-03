package com.woniu.dto;

import lombok.Data;

@Data
public class Result<T> {
    private Boolean flag;
    private Integer Code;
    private String message;
    private T data;

    public Result(Boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        Code = code;
        this.message = message;
        this.data =(T)data;
    }

    public Result(Boolean flag, Integer code, String message) {
        this.flag = flag;
        Code = code;
        this.message = message;
    }

    public Result() {
        this.flag = true;
        Code = StatusCode.OK;
        this.message = "操作成功";
    }
}
