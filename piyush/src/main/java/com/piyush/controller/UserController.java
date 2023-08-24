package com.piyush.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/")
	public String myMessage() {
		
		return "Hello piyush";
		
	}
	
	@GetMapping("/user")
	public String userMessage() {
		
		return "Hello user";
		
	}
	
	@GetMapping("/admin")
	public String adminMessage() {
		
		return "Hello admin";
		
	}

}
