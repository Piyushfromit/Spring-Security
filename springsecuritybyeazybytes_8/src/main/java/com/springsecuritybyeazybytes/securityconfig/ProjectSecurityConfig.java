package com.springsecuritybyeazybytes.securityconfig;

import com.springsecuritybyeazybytes.filter.AuthoritiesLoggingAfterFilter;
import com.springsecuritybyeazybytes.filter.AuthoritiesLoggingAtFilter;
import com.springsecuritybyeazybytes.filter.CsrfCookieFilter;
import com.springsecuritybyeazybytes.filter.RequestValidationBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.csrf.XorCsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

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
                .securityContext((context) -> context
                        .requireExplicitSave(false))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                )
                .cors(cors -> cors.configurationSource(eazyBankCorsConfiguration()))
                .csrf(  csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(csrfTokenRequestAttributeHandler)
                        .ignoringRequestMatchers("/register" )
                )
                 .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                 .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                 .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
                 .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                 .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers("/myAccount").hasRole("USER")
                        .requestMatchers("/myBalance").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/myLoans").hasRole("USER")
                        .requestMatchers("/myCards").hasRole("USER")

                        .requestMatchers( "/user").authenticated()
//                        .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLoans", "/user", "/contact").authenticated()
                        .requestMatchers( "/notices", "/register").permitAll()
                )

               .formLogin(Customizer.withDefaults())
               .httpBasic(Customizer.withDefaults());

         return http.build();
    }

    @Bean
    CorsConfigurationSource eazyBankCorsConfiguration() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // "*"
        config.setAllowedMethods(Collections.singletonList("*")); // "*"
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Collections.singletonList("*"));
        config.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



}
