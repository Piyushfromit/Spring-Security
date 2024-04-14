package com.springsecuritybyeazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springsecuritybyeazybytes.controller")
public class SpringsecuritybyeazybytesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritybyeazybytesApplication.class, args);
		System.out.println("piyush");
	}

}
