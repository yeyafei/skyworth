package com.skyworth.sop.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.skyworth.sop.bean.R;
import com.skyworth.sop.enums.ErrorCode;

/**
* 用户登录失败拦截
* 
* @author yyf
* @date 2018年12月20日
*/
@Component
public class SysAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
    	httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
    	//用户名不存在
    	if(e instanceof UsernameNotFoundException)
    		httpServletResponse.getWriter().write(JSONObject.toJSONString(new R<>().error(ErrorCode.USER_NOT_EXIST.getCode(), ErrorCode.USER_NOT_EXIST.getDesc())));
        //密码错误
    	if(e instanceof BadCredentialsException)
        	httpServletResponse.getWriter().write(JSONObject.toJSONString(new R<>().error(ErrorCode.USER_PASSWORD_ERROR.getCode(), ErrorCode.USER_PASSWORD_ERROR.getDesc())));
    }

}
