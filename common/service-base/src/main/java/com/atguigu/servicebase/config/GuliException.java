package com.atguigu.servicebase.config;

/**
 * @auther: zzzgyu
 */

public class GuliException extends RuntimeException {

    private Integer code;

    private String message;

    public GuliException() {
    }

    public GuliException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
