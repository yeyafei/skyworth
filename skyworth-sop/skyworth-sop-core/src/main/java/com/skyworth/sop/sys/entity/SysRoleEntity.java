package com.skyworth.sop.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.skyworth.sop.bean.DataEntity;


/**
 * 系统角色表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@TableName("sys_role")
public class SysRoleEntity extends DataEntity<SysRoleEntity> {

	private static final long serialVersionUID = 1L;
    
    /**
	 * 角色Code
	 */
    private String roleCode;
    
    /**
	 * 角色名
	 */
    private String roleName;
	
	/**
	 * 获取：角色Code
	 */
	public String getRoleCode() {
		return roleCode;
	}
	
	/**
	 * 设置：角色Code
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	
	/**
	 * 获取：角色名
	 */
	public String getRoleName() {
		return roleName;
	}
	
	/**
	 * 设置：角色名
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

    @Override
	public String toString() {
	     return ReflectionToStringBuilder.toString(this);
	}
}
