package com.skyworth.sop.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.skyworth.sop.bean.DataEntity;


/**
 * 系统用户表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@TableName("sys_user")
public class SysUserEntity extends DataEntity<SysUserEntity> {

	private static final long serialVersionUID = 1L;
    
    /**
	 * 用户名
	 */
    private String userName;
    
    /**
	 * 密码
	 */
    private String password;
	
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

    @Override
	public String toString() {
	     return ReflectionToStringBuilder.toString(this);
	}
}
