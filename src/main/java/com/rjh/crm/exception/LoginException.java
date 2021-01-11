package com.rjh.crm.exception;

/**
 * @author rjh
 * @date 2021/1/11 22:19
 */
public class LoginException extends Exception{
    public LoginException() {}
    public LoginException(String msg) {
        super(msg);
    }
}
