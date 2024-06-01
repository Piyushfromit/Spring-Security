package com.springsecuritybyeazybytes.securityconfig;


import com.springsecuritybyeazybytes.filter.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {
    // doc Link :     https://docs.spring.io/spring-security/reference/servlet/configuration/java.html


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        CsrfTokenRequestAttributeHandler csrfTokenRequestAttributeHandler = new CsrfTokenRequestAttributeHandler();
        csrfTokenRequestAttributeHandler.setCsrfRequestAttributeName("_csrf");


        http
            .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLone", "/user").authenticated()
            .requestMatchers("/welcome", "/contactUs", "/notices", "/register").permitAll()
            .anyRequest().permitAll()

        )
        .cors((cors) -> cors.configurationSource(eazyBankCorsConfiguration()))
        .csrf((csrf) -> csrf.csrfTokenRequestHandler(csrfTokenRequestAttributeHandler).ignoringRequestMatchers("/register", "/contactUs")
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
        .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)

        .formLogin(withDefaults())
        .httpBasic(withDefaults());

     return  http.build();
    }

    @Bean
    CorsConfigurationSource eazyBankCorsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // "*"
        config.setAllowedMethods(Arrays.asList("GET","POST"));   // "*"
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}




