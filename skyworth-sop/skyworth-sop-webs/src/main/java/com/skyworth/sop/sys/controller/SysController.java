package com.skyworth.sop.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
* 模拟登录&测试无权限
*
* @author yyf
* @date 2018年12月20日
*/
@Api(value = "模拟登录&登出&测试无权限")
@Controller
public class SysController {
    @PostMapping("/login")
	@ApiOperation(value = "登录")
	public void login(@ApiParam(required = true, value = "username") @RequestParam("username") String username,@ApiParam(required = true, value = "password") @RequestParam("password") String password) {
    }
    
    @PostMapping("/logout")
	@ApiOperation(value = "登出")
	public void logout() {
    }
    
    @PostMapping("/testNoPermission")
	@ApiOperation(value = "无权限测试")
	public void testNoPermission() {
    }
}
