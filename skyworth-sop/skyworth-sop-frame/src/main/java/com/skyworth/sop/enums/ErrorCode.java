package com.skyworth.sop.enums;

/**
 * @program: skyworth-sop
 * @description: 错误枚举类
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-06 15:30
 */
public enum ErrorCode {

	SYSTEM_ERROR("S00001", "系统错误"),
	
	PLZ_LOGIN("S00002", "请登录"),

	USER_NOT_EXIST("S00003", "用户不存在"),

	USER_NO_PERMISSION("S00004", "无权限"),
	
	USER_PASSWORD_ERROR("S00005", "密码错误"),;
	
	private String code;
	private String desc;

	private ErrorCode(String code, String desc) {
            this.setCode(code);
            this.setDesc(desc);
        }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
