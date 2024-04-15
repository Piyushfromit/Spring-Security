package com.springsecuritybyeazybytes.securityconfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        //  Custom Security Configuration
        http.authorizeHttpRequests(authorize -> authorize
               .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLone").authenticated()
               .requestMatchers("/welcome", "/contactUs", "/notices").permitAll()
               .anyRequest().permitAll()
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults());


        //  Configuration to deny All the request
        http.authorizeHttpRequests(authorize -> authorize
                .anyRequest().denyAll()
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults());


        //  Configuration to permit All the request
        http.authorizeHttpRequests(authorize -> authorize
               .anyRequest().permitAll()
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults());


        return  http.build();
    }
}


// doc Link :     https://docs.spring.io/spring-security/reference/servlet/configuration/java.html

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.authorizeHttpRequests(request -> request
//                        .requestMatchers("/admin/**").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .formLogin(formLogin -> formLogin .defaultSuccessUrl("/admin/dashboard", true) )
//                .logout(logout ->  logout  .permitAll())
//                .csrf(csrf -> csrf.disable());
//        ;
//
//        return  httpSecurity.build();
//    }
//}