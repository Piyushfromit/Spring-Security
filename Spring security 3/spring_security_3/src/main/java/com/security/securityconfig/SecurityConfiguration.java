package com.security.securityconfig;

import javax.annotation.security.PermitAll;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	public void authManager(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.jdbcAuthentication()
	    .dataSource(dataSource)
	    .passwordEncoder(new BCryptPasswordEncoder())
	    .usersByUsernameQuery("select email, password, enabled from users where email=?")
	    .authoritiesByUsernameQuery("select email, authority from authority where email=?");
		

	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http.csrf().disable().authorizeHttpRequests((req) ->req
				
				.antMatchers("/", "/saveuser").permitAll()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/user").hasAnyRole("ADMIN", "USER")
				.anyRequest().authenticated()
				
				).formLogin();
		
		return http.build();
	}
	

	
	
	

}
