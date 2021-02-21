package com.gospell.xiaoyuan.cloud.auth.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gospell.xiaoyuan.cloud.common.security.handler.LoginSuccessHandler;
import com.gospell.xiaoyuan.cloud.common.security.phone.PhoneSecurityConfigurer;
import com.gospell.xiaoyuan.cloud.common.security.service.AuthUserDetailsService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;

/**
 * @author
 * 认证相关配置
 */
@Primary
@Order(90)
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
	@Resource
	private ObjectMapper objectMapper;
    @Resource
	private ClientDetailsService clientDetailsService;
    @Resource
	private AuthUserDetailsService userDetailsService;
	@Lazy
    @Resource
	private AuthorizationServerTokenServices defaultAuthorizationServerTokenServices;

	@Override
	@SneakyThrows
	protected void configure(HttpSecurity http) {
		http
			.formLogin()
			.loginPage("/token/login")
			.loginProcessingUrl("/token/form")
			.and()
			.authorizeRequests()
			.antMatchers(
				"/token/**",
				"/actuator/**",
				"/phone/**").permitAll()
			.anyRequest().authenticated()
			.and().csrf().disable()
			.apply(phoneSecurityConfigurer());
	}

	/**
	 * 不拦截静态资源
	 *
	 * @param web
	 */
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/css/**");
	}

	@Bean
	@Override
	@SneakyThrows
	public AuthenticationManager authenticationManagerBean() {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return LoginSuccessHandler.builder()
			.objectMapper(objectMapper)
			.clientDetailsService(clientDetailsService)
			.passwordEncoder(passwordEncoder())
			.defaultAuthorizationServerTokenServices(defaultAuthorizationServerTokenServices).build();
	}

	@Bean
	public PhoneSecurityConfigurer phoneSecurityConfigurer() {
		PhoneSecurityConfigurer phoneSecurityConfigurer = new PhoneSecurityConfigurer();
		phoneSecurityConfigurer.setMobileLoginSuccessHandler(loginSuccessHandler());
		phoneSecurityConfigurer.setUserDetailsService(userDetailsService);
		return phoneSecurityConfigurer;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
