package com.skyworth.sop.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.skyworth.sop.sys.entity.SysRoleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 系统角色表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRoleEntity> {
	
}
