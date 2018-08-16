package com.study.server.exception;

public class GlobalException extends Exception {
    //异常信息
    public String message;

    public GlobalException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
