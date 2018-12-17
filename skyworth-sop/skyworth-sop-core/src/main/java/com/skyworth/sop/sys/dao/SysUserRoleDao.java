package com.skyworth.sop.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.skyworth.sop.sys.entity.SysUserRoleEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 用户角色关联表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRoleEntity> {
	
}
