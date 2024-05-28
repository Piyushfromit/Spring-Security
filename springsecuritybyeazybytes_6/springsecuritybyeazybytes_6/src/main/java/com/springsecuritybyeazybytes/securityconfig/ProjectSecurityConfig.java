package com.springsecuritybyeazybytes.securityconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;



import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    // doc Link :     https://docs.spring.io/spring-security/reference/servlet/configuration/java.html

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

         http
             .authorizeHttpRequests(authorize -> authorize
               .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLone", "/user").authenticated()
               .requestMatchers("/welcome", "/contactUs", "/notices", "/register").permitAll()
               .anyRequest().permitAll()
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults())
        .csrf(csrf -> csrf.disable());


     return  http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}




