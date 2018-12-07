package com.skyworth.sop.exception;

import com.skyworth.sop.enums.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.skyworth.sop.bean.R;

/**
 * @program: skyworth-sop
 * @description: 错误异常处理
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 15:31
 */
@RestControllerAdvice
public class BaseExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 自定义service异常
     *
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(ServiceException.class)
    public R handleServiceException(ServiceException e) {
        R r = new R();
        r.setCode(e.getErrorCode());
        r.setMsg(e.getMessage());
        return r;
    }



    /**
     * 自定义base异常
     *
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(BaseException.class)
    public R handleServiceException(BaseException e) {
        R r = new R();
        r.setCode(e.getErrorCode());
        r.setMsg(e.getMessage());
        return r;
    }

    /**
     * 系统exception异常
     *
     * @param e
     * @return
     */
    @SuppressWarnings("rawtypes")
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        logger.error(e.getMessage(), e);
        R r = new R();
        r.setCode(ErrorCode.SysErrorType.SYSTEM_ERROR.getCode());
        if (e.getMessage() != null && e.getMessage().length() > 100) {
            r.setMsg(ErrorCode.SysErrorType.SYSTEM_ERROR.getDesc());
        } else {
            r.setMsg(e.getMessage());
        }
        return r;
    }
}