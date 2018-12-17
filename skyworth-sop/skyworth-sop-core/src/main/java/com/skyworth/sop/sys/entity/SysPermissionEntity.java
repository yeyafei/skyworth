package com.skyworth.sop.sys.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.skyworth.sop.bean.DataEntity;


/**
 * 系统权限表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@TableName("sys_permission")
public class SysPermissionEntity extends DataEntity<SysPermissionEntity> {

	private static final long serialVersionUID = 1L;
    
    /**
	 * 权限名
	 */
    private String perName;
    
    /**
	 * 权限URL
	 */
    private String perUrl;
    
    /**
	 * 权限描述
	 */
    private String perTag;
    
    /**
	 * 父节点id
	 */
    private Integer pid;
	
	/**
	 * 获取：权限名
	 */
	public String getPerName() {
		return perName;
	}
	
	/**
	 * 设置：权限名
	 */
	public void setPerName(String perName) {
		this.perName = perName;
	}
	
	/**
	 * 获取：权限URL
	 */
	public String getPerUrl() {
		return perUrl;
	}
	
	/**
	 * 设置：权限URL
	 */
	public void setPerUrl(String perUrl) {
		this.perUrl = perUrl;
	}
	
	/**
	 * 获取：权限描述
	 */
	public String getPerTag() {
		return perTag;
	}
	
	/**
	 * 设置：权限描述
	 */
	public void setPerTag(String perTag) {
		this.perTag = perTag;
	}
	
	/**
	 * 获取：父节点id
	 */
	public Integer getPid() {
		return pid;
	}
	
	/**
	 * 设置：父节点id
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

    @Override
	public String toString() {
	     return ReflectionToStringBuilder.toString(this);
	}
}
