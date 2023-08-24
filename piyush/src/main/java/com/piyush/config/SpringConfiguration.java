package com.piyush.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SpringConfiguration {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select email,password,enabled " + "from bael_users " + "where email = ?")
				.authoritiesByUsernameQuery("select email,authority " + "from authorities " + "where email = ?");
	}

	
//	  @Bean public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws Exception { 
//		  
//		  httpSecurity.authorizeRequests()
//		  .requestMatchers("/h2-console/**") .permitAll() .anyRequest() .authenticated()
//		  .and() .formLogin();
//		 
//		   httpSecurity.csrf() .ignoringRequestMatchers("/h2-console/**");
//		   httpSecurity.headers() .frameOptions() .sameOrigin(); return httpSecurity.build();
//		   
//	  
//	  }
	 

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeHttpRequests((req) -> req

				.requestMatchers("/", "/register").permitAll().requestMatchers("/admin").hasRole("ADMIN")
				.requestMatchers("/user").hasAnyRole("ADMIN", "USER").anyRequest().authenticated()

		).formLogin();

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
