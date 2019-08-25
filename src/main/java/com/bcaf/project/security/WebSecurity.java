//package com.bcaf.project.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpMethod;
//
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//
//import com.bcaf.project.model.UserDetailsServiceImpl;
//
//@Configuration
//@Order(2)
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurity extends WebSecurityConfigurerAdapter {
//	@Autowired
//	private UserPrincipalService userService;
//	
//	private UserDetailsServiceImpl userDetailsService;
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//    public WebSecurity(UserDetailsServiceImpl userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//    
//	@Override
//	public void configure(final AuthenticationManagerBuilder auth) throws Exception{
//		/*
//		auth.inMemoryAuthentication()
//			.withUser("user1").password(passwordEncoder().encode("user123")).roles("USER")
//			.and()
//			.withUser("user2").password(passwordEncoder().encode("user123")).roles("USER","ADMIN","MANAGER")
//			.and()
//			.withUser("admin1").password(passwordEncoder().encode("admin123")).roles("ADMIN")
//			.and()
//			.withUser("manager1").password(passwordEncoder().encode("manager123")).roles("MANAGER");
//			
//		*/
//		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//		auth.authenticationProvider(authenticationProvider());
//	}
//	
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception{
//		http.cors().and().csrf().disable()
//		.authorizeRequests()
//		.antMatchers("/home").hasRole("USER")
//		.antMatchers("/home","/admin","/provinsi/*").hasAnyRole("ADMIN", "HEAD", "TEAMLEADER")
//		.antMatchers("/manager").hasRole("MANAGER")
//		.antMatchers("/login").permitAll()
//		.antMatchers(HttpMethod.POST).permitAll()
//        .anyRequest().authenticated()
//        .and()
//        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
//        .addFilter(new JWTAuthorizationFilter(authenticationManager()))
//		.formLogin()
//		.loginPage("/login").permitAll()
//		.loginProcessingUrl("/login")
//		.defaultSuccessUrl("/home")
//		.and()
//		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
//		.and()
//		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).maximumSessions(2)
//		.expiredUrl("/session-expired");
//	}
//	
//
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
//		daoAuthProvider.setPasswordEncoder(passwordEncoder());
//		daoAuthProvider.setUserDetailsService(this.userService);
//		return daoAuthProvider;
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//
//  @Bean
//  CorsConfigurationSource corsConfigurationSource() {
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//    return source;
//  }
//	
//	
//}
