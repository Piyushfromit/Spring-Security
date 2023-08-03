package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	//authentication
	public UserDetailsService userDetailService()
	{
		
		return new UserInfoUserDetailService();
	}
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		return http.csrf().disable()
//		.authorizeHttpRequests()
//		.antMatchers("/user","/new").permitAll()
//		.and()
//		.authorizeHttpRequests()
//		.antMatchers("/admin/**")
//		.authenticated()
//		.and()
//		.formLogin().and()
//		.build();
//	}
	
	
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    return http
//	        .csrf().disable()
//	        .authorizeRequests(authorizeRequests ->
//	            authorizeRequests
//	                .antMatchers("/user", "/new").permitAll()
//	                .antMatchers("/admin/**").authenticated()
//	        )
//	        .formLogin(formLogin ->
//	            formLogin
//	                .loginPage("/login") // Specify your custom login page URL
//	                .permitAll() // Allow anyone to access the login page
//	        )
//	        .build();
//	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    return http
	        .csrf().disable()
	        .authorizeRequests(authorizeRequests ->
	            authorizeRequests
	                .antMatchers("/user", "/new").permitAll()
	                .antMatchers("/admin/**").authenticated()
	        )
	        .formLogin(formLogin ->
	            formLogin
	                .loginPage("/login") // Specify your custom login page URL
	                .permitAll() // Allow anyone to access the login page
	                .defaultSuccessUrl("/welcome") // Redirect to /welcome controller after successful login
	        )
	        .build();
	}
	
	
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	/*
	 * @Bean public AuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authenticationProvider = new
	 * DaoAuthenticationProvider();	
	 * authenticationProvider.setUserDetailsService(userDetailService());
	 * authenticationProvider.setPasswordEncoder(passwordEncoder()); return
	 * authenticationProvider; }
	 */
	
	
}
