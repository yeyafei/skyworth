package com.skyworth.sop.bean;

import java.io.Serializable;



/**
 * 基础实体对象
 * 
 */
public abstract class BaseEntity<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 删除标记（0：正常；1：删除；）
	 */
	public static final String DEL_FLAG_NORMAL = "0";
	public static final String DEL_FLAG_DELETE = "1";
	

	public BaseEntity() {
		
	}


}
