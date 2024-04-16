package com.springsecuritybyeazybytes.securityconfig;


import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    // doc Link :     https://docs.spring.io/spring-security/reference/servlet/configuration/java.html

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

         http.authorizeHttpRequests(authorize -> authorize
               .requestMatchers("/myAccount", "/myBalance", "/myCards", "/myLone").authenticated()
               .requestMatchers("/welcome", "/contactUs", "/notices").permitAll()
               .anyRequest().permitAll()
        )
        .formLogin(withDefaults())
        .httpBasic(withDefaults());
     return  http.build();
    }

    // Approach 1 for InMemoryUserDetailsManager

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService1() throws Exception {
//
//        UserDetails users1 = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("123456")
//                .roles("admin")
//                .build();
//        UserDetails users2 = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("123456")
//                .roles("read")
//                .build();
//
//        return new InMemoryUserDetailsManager(users1, users2);
//    }

    // Approach 2 for InMemoryUserDetailsManager
    @Bean
    public InMemoryUserDetailsManager userDetailsService2() throws Exception {

        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

        UserDetails user= User.withUsername("admin").password("12345678").authorities("USER").build();
        UserDetails admin= User.withUsername("user").password("12345678").authorities("USER","ADMIN").build();
        inMemoryUserDetailsManager.createUser(user);
        inMemoryUserDetailsManager.createUser(admin);
        return inMemoryUserDetailsManager;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}




