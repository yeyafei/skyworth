package com.skyworth.sop.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.skyworth.sop.sys.entity.SysRolePerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 角色权限关联表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Mapper
public interface SysRolePerDao extends BaseMapper<SysRolePerEntity> {
	
}
