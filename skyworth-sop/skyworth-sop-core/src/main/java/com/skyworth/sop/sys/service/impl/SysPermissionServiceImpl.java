package com.skyworth.sop.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.skyworth.sop.sys.dao.SysPermissionDao;
import com.skyworth.sop.sys.entity.SysPermissionEntity;
import com.skyworth.sop.sys.service.SysPermissionService;

/**
 * 系统权限表实现类
 *
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermissionEntity> implements SysPermissionService {

	@Override
	public List<SysPermissionEntity> findByUserId(Integer id) {
		// TODO Auto-generated method stub
		return baseMapper.findByUserId(id);
	}


}
