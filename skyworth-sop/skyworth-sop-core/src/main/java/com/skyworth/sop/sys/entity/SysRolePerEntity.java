package com.skyworth.sop.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.skyworth.sop.bean.DataEntity;


/**
 * 角色权限关联表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@TableName("sys_role_per")
public class SysRolePerEntity extends DataEntity<SysRolePerEntity> {

	private static final long serialVersionUID = 1L;
    
    /**
	 * 
	 */
    private Integer roleId;
    
    /**
	 * permissionId
	 */
    private Integer perId;
	
	/**
	 * 获取：
	 */
	public Integer getRoleId() {
		return roleId;
	}
	
	/**
	 * 设置：
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * 获取：permissionId
	 */
	public Integer getPerId() {
		return perId;
	}
	
	/**
	 * 设置：permissionId
	 */
	public void setPerId(Integer perId) {
		this.perId = perId;
	}

    @Override
	public String toString() {
	     return ReflectionToStringBuilder.toString(this);
	}
}
