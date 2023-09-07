package com.mscgift.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		
		 return new UsersUserDetailsService();
		 
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http)throws Exception {
		http
        .authorizeHttpRequests(authorizeRequests ->
            authorizeRequests
                .requestMatchers("/","/hi","/register","/jsp").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN") // Requires role "ADMIN" for /admin/**
                .requestMatchers("/user/**").hasRole("USER") // Requires role "USER" for /user/**
                .anyRequest().permitAll()
        )
        .formLogin(formLogin -> formLogin .permitAll() )
        .logout(logout ->  logout  .permitAll())
        .csrf(csrf -> csrf.disable());

        return http.build();
		
//		return http
//				.csrf().disable()
//				.authorizeHttpRequests()
//				.requestMatchers("/","/hi","/register").permitAll()
//				.and()
//				.authorizeHttpRequests()
//				.requestMatchers("/admin**").authenticated()
//				.and().formLogin()
//				.and().build();
		
    	
	}
	
	
	@Bean PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider(){
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return authenticationProvider;
		
	}
	

}
