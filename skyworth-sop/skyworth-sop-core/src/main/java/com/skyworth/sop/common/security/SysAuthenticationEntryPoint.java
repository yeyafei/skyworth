package com.skyworth.sop.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.skyworth.sop.bean.R;
import com.skyworth.sop.enums.ErrorCode;

/**
* 未登录用户拦截
* 
* @author yyf
* @date 2018年12月20日
*/
@Component
public class SysAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
    	httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
    	httpServletResponse.getWriter().write(JSONObject.toJSONString(new R<>().error(ErrorCode.PLZ_LOGIN.getCode(), ErrorCode.PLZ_LOGIN.getDesc())));
    }

}
