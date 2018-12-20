package com.skyworth.sop.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


/**
 *
 *
 * @author yyf
 * @date 2018年12月20日
 */
@Component
public class SysAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private SecurityUserService userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = (String) authentication.getPrincipal(); 
		String password = (String) authentication.getCredentials(); 

		UserDetails userInfo = userDetailsService.loadUserByUsername(userName);

		if (!userInfo.getPassword().equals(password)) {
			throw new BadCredentialsException("password error");
		}

		return new UsernamePasswordAuthenticationToken(userName, password, userInfo.getAuthorities());
	}

	@Override
	    public boolean supports(Class<?> authentication) {
	        return true;
	    }
}
