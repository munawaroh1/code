//package com.bcaf.project.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@Order(1)
//
//public class ApiConfigure extends WebSecurityConfigurerAdapter{
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http
//			.antMatcher("/api/**").authorizeRequests()
//				.and().csrf().disable()
//			.httpBasic();
//	}
//	
//	@Override
//	public void configure(WebSecurity web) throws Exception{
//		web.ignoring().antMatchers("/api/**/*.wsdl");
//	}
//	
//	/*
//	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
//	 * Exception { auth.authenticationProvider(DaoAuthenticationProvider())); }
//	 */
//
//}
