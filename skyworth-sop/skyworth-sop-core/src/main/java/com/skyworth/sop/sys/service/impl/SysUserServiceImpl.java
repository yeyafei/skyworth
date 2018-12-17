package com.skyworth.sop.sys.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.skyworth.sop.sys.dao.SysUserDao;
import com.skyworth.sop.sys.entity.SysUserEntity;
import com.skyworth.sop.sys.service.SysUserService;

/**
 * 系统用户表实现类
 *
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUserEntity> implements SysUserService {


}
