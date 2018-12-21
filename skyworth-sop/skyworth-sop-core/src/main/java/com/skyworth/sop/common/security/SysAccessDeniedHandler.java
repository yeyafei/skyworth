package com.skyworth.sop.common.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.skyworth.sop.bean.R;
import com.skyworth.sop.enums.ErrorCode;

/**
* 无权限用户拦截
*
* @author yyf
* @date 2018年12月20日
*/
@Component
public class SysAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
    	httpServletResponse.setHeader("Content-type", "text/html;charset=UTF-8");
    	httpServletResponse.getWriter().write(JSONObject.toJSONString(new R<>().error(ErrorCode.USER_NO_PERMISSION.getCode(), ErrorCode.USER_NO_PERMISSION.getDesc())));
    }

}
