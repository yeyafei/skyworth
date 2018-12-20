package com.skyworth.sop.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.skyworth.sop.sys.entity.SysPermissionEntity;


/**
 * 系统权限表
 *
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
public interface SysPermissionService extends IService<SysPermissionEntity> {

	List<SysPermissionEntity> findByUserId(Integer id);

}

