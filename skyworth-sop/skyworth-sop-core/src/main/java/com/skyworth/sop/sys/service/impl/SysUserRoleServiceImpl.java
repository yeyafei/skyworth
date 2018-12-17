package com.skyworth.sop.sys.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.skyworth.sop.sys.dao.SysUserRoleDao;
import com.skyworth.sop.sys.entity.SysUserRoleEntity;
import com.skyworth.sop.sys.service.SysUserRoleService;

/**
 * 用户角色关联表实现类
 *
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRoleEntity> implements SysUserRoleService {


}
