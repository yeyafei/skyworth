package com.skyworth.sop.exception;

import com.skyworth.sop.constant.Constant;

/**
 * @program: skyworth-sop
 * @description:  基本异常
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 15:33
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private String errorCode;

    public BaseException() {
        super();
    }

    public BaseException(Throwable e) {
        super(e);
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String errorCode, String msg) {
        this(msg);
        this.errorCode = errorCode;
    }

    public BaseException(String errorCode, String msg, Throwable e) {
        super(msg, e);
        this.errorCode = errorCode;
    }
   
    public BaseException(String msg, Throwable e) {
        super(msg, e);
        this.errorCode = Constant.BASE_DEFAULT_ERROR_CODE;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
