package com.skyworth.sop.test.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.skyworth.sop.bean.DataEntity;


/**
 * 测试表TEST
 * 
 * @author yeyafei
 * @date 2018-12-07 14:50:14
 */
@TableName("test")
public class TestEntity extends DataEntity<TestEntity> {

	private static final long serialVersionUID = 1L;
    
    /**
	 * 测试列一
	 */
    private String test1;
    
    /**
	 * 测试列二
	 */
    private String test2;
	
	/**
	 * 获取：测试列一
	 */
	public String getTest1() {
		return test1;
	}
	
	/**
	 * 设置：测试列一
	 */
	public void setTest1(String test1) {
		this.test1 = test1;
	}
	
	/**
	 * 获取：测试列二
	 */
	public String getTest2() {
		return test2;
	}
	
	/**
	 * 设置：测试列二
	 */
	public void setTest2(String test2) {
		this.test2 = test2;
	}

    @Override
	public String toString() {
	     return ReflectionToStringBuilder.toString(this);
	}
}
