package com.skyworth.sop.bean;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 数据Entity类
 */
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;

	protected Integer id; //id
	protected String remarks; // 备注
	@TableField(fill = FieldFill.INSERT) 
	protected Date createTime; // 创建日期
	@TableField(fill = FieldFill.INSERT_UPDATE)
	protected Date updateTime; // 更新日期
	
	@TableField(fill = FieldFill.INSERT) 
	protected Date createName; // 创建人
	@TableField(fill = FieldFill.INSERT_UPDATE)
	protected Date updateName; // 更新人
	@TableLogic
	protected String delFlag; // 删除标记（0：正常；1：删除；2：审核）

	public DataEntity() {
		super();
		this.delFlag = DEL_FLAG_NORMAL;
	}
	
	@Length(min = 0, max = 255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+08:00")
	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@JsonIgnore
	@Length(min = 1, max = 1)
	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateName() {
		return createName;
	}

	public void setCreateName(Date createName) {
		this.createName = createName;
	}

	public Date getUpdateName() {
		return updateName;
	}

	public void setUpdateName(Date updateName) {
		this.updateName = updateName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
