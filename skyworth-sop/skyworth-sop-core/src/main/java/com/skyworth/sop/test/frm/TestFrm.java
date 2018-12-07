package com.skyworth.sop.test.frm;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.skyworth.sop.bean.PageFrm;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: skyworth-sop
 * @description: 测试Test表单类
 * @author: yeyafei
 * @email:yeyafei@hotmail.com
 * @create: 2018-12-07 15:13
 */
public class TestFrm extends PageFrm{
	
	private Integer id;
	/**
	 * 测试列一
	 */
	@ApiModelProperty(value = "测试列一")
	private String test1;

	/**
	 * 测试列二
	 */
	@ApiModelProperty(value = "测试列二")
	private String test2;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
