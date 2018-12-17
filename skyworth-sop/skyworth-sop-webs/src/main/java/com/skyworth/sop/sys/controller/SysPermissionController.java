package com.skyworth.sop.sys.controller;


import io.swagger.annotations.Api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.skyworth.sop.sys.service.SysPermissionService;

/**
 * 系统权限表
 *
 * @author yeyafei
 * @date 2018-12-17 15:32:08
 */
@Api(value = "系统权限表")
@RestController
@RequestMapping("sys/syspermission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;


}
