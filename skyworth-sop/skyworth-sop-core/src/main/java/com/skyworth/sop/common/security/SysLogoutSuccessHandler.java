package com.skyworth.sop.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.skyworth.sop.bean.R;

/**
* 登出成功拦截
*
* @author yyf
* @date 2018年12月20日
*/
@Component
public class SysLogoutSuccessHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest arg0, HttpServletResponse httpServletResponse, Authentication arg2)throws IOException, ServletException {
    	httpServletResponse.getWriter().write(JSONObject.toJSONString(new R<>().ok("success")));
	}

}
