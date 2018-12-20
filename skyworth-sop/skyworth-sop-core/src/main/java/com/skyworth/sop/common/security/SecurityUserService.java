package com.skyworth.sop.common.security;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.skyworth.sop.enums.ErrorCode;
import com.skyworth.sop.sys.entity.SysPermissionEntity;
import com.skyworth.sop.sys.entity.SysUserEntity;
import com.skyworth.sop.sys.service.SysPermissionService;
import com.skyworth.sop.sys.service.SysUserService;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月26日 下午8:56:02
 * @version 1.0
 */
@Service
public class SecurityUserService implements UserDetailsService {
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysPermissionService permissionService;

	@Override
	public UserDetails loadUserByUsername(String userName) {
		EntityWrapper<SysUserEntity> wr = new EntityWrapper<SysUserEntity>();
		wr.eq("user_name", userName);
		SysUserEntity user = userService.selectOne(wr);
		if (user != null) {
			List<SysPermissionEntity> permissions = permissionService.findByUserId(user.getId());
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (SysPermissionEntity permission : permissions) {
				if (permission != null && permission.getPerName() != null) {
					GrantedAuthority grantedAuthority = new SysPermissionEntity(permission.getPerUrl(),
							permission.getPerName());
					grantedAuthorities.add(grantedAuthority);
				}
			}
			user.setGrantedAuthorities(grantedAuthorities);
			return user;
		} else {
			throw new UsernameNotFoundException(ErrorCode.USER_NOT_EXIST.getDesc());
		}
	}
}
