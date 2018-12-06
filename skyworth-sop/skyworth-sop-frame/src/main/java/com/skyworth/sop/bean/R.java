package com.skyworth.sop.bean;

import com.skyworth.sop.constant.Constant;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @program: skyworth-sop
 * @description: RestBean
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 15:14
 */
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String msg;

    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    public R<T> ok(T data) {
        this.code = Constant.OK;
        this.data = data;
        return this;
    }


    public R<T> success(String msg) {
        this.code = Constant.OK;
        this.msg = msg;
        return this;
    }

    public R<T> error(String code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}