package com.ssm.exception;

/**
 * @author 张镠
 * @date 2019/7/23 - 18:17
 * 自定义异常类,针对预期的异常，抛出此异常
 */
public class CustomException extends Exception{

    //异常信息
    public String message;

    public CustomException(String message){
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
