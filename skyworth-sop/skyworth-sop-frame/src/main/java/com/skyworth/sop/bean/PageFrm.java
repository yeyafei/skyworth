package com.skyworth.sop.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页基础类
 * @author yeyafei
 *
 */
public class PageFrm {
	
	/**
	 * 每页数量
	 */
	@ApiModelProperty(value = "每页数量",example="10")
	public String limit;
	
	/**
	 * 页码
	 */
	@ApiModelProperty(value = "当前页",example="1")
	public String page;
	
	@ApiModelProperty(value = "排序字段: 数据库字段" )
	public String sidx;
	
	
	@ApiModelProperty(value = "ASC:升序，DESC:降序",example="DESC")
	public String order;

	
	public String getSidx() {
		return sidx;
	}

	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Map<String, Object> pageParam() {
		Map<String, Object> param = new HashMap<>();
		if(isInteger(limit)&&isInteger(page)) {
			param.put("limit", limit);
			param.put("page", page);
		}
		param.put("sidx", sidx);
		param.put("order", order);
		return param;
	}
	
	public boolean isInteger(String str) {  
	    Pattern pattern = Pattern.compile("[0-9]*");  
	    return pattern.matcher(str).matches();  
	}

}
