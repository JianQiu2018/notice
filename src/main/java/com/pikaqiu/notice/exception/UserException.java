package com.pikaqiu.notice.exception;

/**
 * Description:
 *
 * @author 贞子
 * @date 2019/8/7 23:36
 */
public class UserException extends RuntimeException{

    private Integer errorCode;

    public UserException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

}