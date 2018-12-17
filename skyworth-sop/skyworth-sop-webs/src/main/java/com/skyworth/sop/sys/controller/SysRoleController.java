package com.skyworth.sop.sys.controller;


import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skyworth.sop.sys.service.SysRoleService;

/**
 * 系统角色表
 *
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Api(value = "系统角色表")
@RestController
@RequestMapping("sys/sysrole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;


}
