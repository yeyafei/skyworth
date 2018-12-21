package com.skyworth.sop.common.security;


import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import com.skyworth.sop.sys.entity.SysPermissionEntity;

/**
 * @Description: 验证权限
 * @author yyf
 * @date 2018年3月26日 下午8:51:07
 * @version 1.0
 */
@Service
public class SecurityAccessDecisionManager implements AccessDecisionManager {
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
		for (GrantedAuthority ga : authentication.getAuthorities()) {
			if (ga instanceof SysPermissionEntity) {
				SysPermissionEntity permission = (SysPermissionEntity) ga;
				String url = permission.getPerUrl();
				if(matchers(url, request))
					return;
			}
		}
		throw new AccessDeniedException("no right permission");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	private boolean matchers(String url, HttpServletRequest request) {
		AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
		if (matcher.matches(request)) {
			return true;
		}
		return false;
	}

}
