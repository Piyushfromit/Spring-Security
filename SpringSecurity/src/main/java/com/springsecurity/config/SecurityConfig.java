package com.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
	
	
	@Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/public/**","/","/login").permitAll()
                .and()
                .authorizeHttpRequests()
        		.antMatchers("/admin/**","/proadmin/**","/welcome")
        		.authenticated()
        		.and()
				
        		 .formLogin(formLogin -> 
        		 formLogin.loginPage("/login").permitAll())
				 .formLogin(formLogin ->
        		 formLogin.defaultSuccessUrl("/welcome") );
               
                
        
        
        return  httpSecurity.build();
    }
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	
}
