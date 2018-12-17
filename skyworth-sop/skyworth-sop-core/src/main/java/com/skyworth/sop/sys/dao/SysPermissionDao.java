package com.skyworth.sop.sys.dao;

import org.apache.ibatis.annotations.Mapper;

import com.skyworth.sop.sys.entity.SysPermissionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * 系统权限表
 * 
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Mapper
public interface SysPermissionDao extends BaseMapper<SysPermissionEntity> {
	
}
