package com.skyworth.sop.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @Description: TODO
 * @author yyf
 * @date 2018年3月24日 上午9:41:06
 * @version 1.0
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityMetadataSource metadataSource;

	@Autowired
	private SecurityAccessDecisionManager accessDecisionManager;

	@Autowired
	private SysAuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private SysAccessDeniedHandler accessDeniedException;

	@Autowired
	private SysAuthenticationSuccessHandler authenticationSuccessHandler;

	@Autowired
	private SysAuthenticationFailureHandler authenticationFailureHandler;

	@Autowired
	private SysLogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
    private SysAuthenticationProvider authenticationProvider; 

	/*** 设置不拦截规则 */
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/images/**", "/js/**", "/css/**", "/swagger-ui.html",
				"/swagger-resources/**", "/v2/api-docs/**", "/webjars/**","/configuration/**");
	}
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        // 加入自定义的安全认证
	        auth.authenticationProvider(authenticationProvider);
	    }


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()

				.httpBasic().authenticationEntryPoint(authenticationEntryPoint)

				.and().authorizeRequests()
				.withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

					@Override
					public <O extends FilterSecurityInterceptor> O postProcess(O o) {
						o.setSecurityMetadataSource(metadataSource);
						o.setAccessDecisionManager(accessDecisionManager);
						return o;
					}
				})
				.anyRequest().authenticated()
				.and().formLogin() 
				.successHandler(authenticationSuccessHandler) 
				.failureHandler(authenticationFailureHandler)
				.permitAll().and().logout().logoutSuccessHandler(logoutSuccessHandler).permitAll();
		http.exceptionHandling().accessDeniedHandler(accessDeniedException);
	}


	@Bean
	public SessionRegistry getSessionRegistry() {
		SessionRegistry sessionRegistry = new SessionRegistryImpl();
		return sessionRegistry;
	}
}
