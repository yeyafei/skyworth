package com.skyworth.sop.sys.controller;


import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skyworth.sop.sys.service.SysUserRoleService;

/**
 * 用户角色关联表
 *
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Api(value = "用户角色关联表")
@RestController
@RequestMapping("sys/sysuserrole")
public class SysUserRoleController {
    @Autowired
    private SysUserRoleService sysUserRoleService;


}
