package com.springsecuritybyeazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
public class EasyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyBankBackendApplication.class, args);

		String bgColorYellow = "\u001B[103m";
		String greenColorCode = "\u001B[32;1m";
		String resetColorCode = "\u001B[0m";
		System.out.println(  greenColorCode + bgColorYellow +"   Hello Piyush   " + resetColorCode );

		
	}

}
