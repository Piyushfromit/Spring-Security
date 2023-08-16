package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "<h1>Welcome to my website : </h1>";
	}
	
	@GetMapping("/admin")
	public String adminProcess() {
		return "<h1>Welcome Admin : </h1>";
	}
	
	@GetMapping("/user")
	public String userProcess() {
		return "<h1>Welcome User : </h1>";
	}
	

}
