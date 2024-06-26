package com.springsecuritybyeazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springsecuritybyeazybytes.controller")
public class SpringsecuritybyeazybytesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringsecuritybyeazybytesApplication.class, args);


		String bgColorYellow = "\u001B[103m";
		String greenColorCode = "\u001B[32;1m";
		String resetColorCode = "\u001B[0m";
		System.out.println(  greenColorCode + bgColorYellow +"   Hello Piyush   " + resetColorCode );

		
	}

}
