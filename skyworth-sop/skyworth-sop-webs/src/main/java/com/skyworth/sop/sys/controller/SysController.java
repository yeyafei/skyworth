package com.skyworth.sop.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.annotations.ApiParam;

/**
*
*
* @author yyf
* @date 2018年12月20日
*/
@Controller
public class SysController {
    @PostMapping("/login")
	public void login(@ApiParam(required = true, value = "username") @RequestParam("username") String username,@ApiParam(required = true, value = "password") @RequestParam("password") String password) {
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
    
    @PostMapping("/testNoPermission")
	public void testNoPermission() {
    	System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
