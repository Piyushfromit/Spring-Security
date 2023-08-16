package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.entity.User;
import com.spring.service.UserService;




@Controller
public class AuthController {
	
	@Autowired
	UserService userService;
	
	
	
	@GetMapping("/message")
	@ResponseBody
	public String HelloMessage() {
		
		return "Hello Dear U Are logedin Successfully";
	}
	
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registerUser(){
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(User user)
	{
		System.out.println("registered");
		this.userService.regUser(user);
		return "register";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/welcome")
	public String welcome(){
		return "home";
	}
	
	

}
