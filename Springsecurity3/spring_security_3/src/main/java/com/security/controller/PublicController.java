package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.Users;
import com.security.repository.UserRepository;
import com.security.service.UserService;

@RestController
public class PublicController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@GetMapping("/")
	public String welcomeMessage() {
		return "<h1>Welcome to my website : </h1>";
	}
	
	@PostMapping("/register")
	public String registerUser(@RequestBody Users user ) {
		
		if(userRepository.findByEmail(user.getEmail()).isPresent()) {
			return "MailId already Exist";
		}
		final Users regUser = this.userService.registerUser(user);
		
		return "<h1> User Saved </h1>";
	}
	
	
	

}
