package com.skyworth.sop.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.skyworth.sop.bean.DataEntity;


/**
 * 用户角色关联表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@TableName("sys_user_role")
public class SysUserRoleEntity extends DataEntity<SysUserRoleEntity> {

	private static final long serialVersionUID = 1L;
    
    /**
	 * userId
	 */
    private Integer userId;
    
    /**
	 * roleId
	 */
    private Integer roleId;
	
	/**
	 * 获取：userId
	 */
	public Integer getUserId() {
		return userId;
	}
	
	/**
	 * 设置：userId
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	/**
	 * 获取：roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置：roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

    @Override
	public String toString() {
	     return ReflectionToStringBuilder.toString(this);
	}
}
