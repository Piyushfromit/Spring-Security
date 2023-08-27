package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springsecurity.config.UserInfoUserDetails;
import com.springsecurity.entity.UserInfo;
import com.springsecurity.service.SpringService;

@Controller
public class AdminController {
	
	@Autowired
	private SpringService service;
	
	@GetMapping("/")
	public String admin()
	{
		return "index";
	}
	
	@GetMapping("/register")
	public String registerUser(){
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser( UserInfo userInfo)
	{
		System.out.println("registered");
		this.service.addUser(userInfo);
		return "register";
	}
	
	@GetMapping("/login")
	String login() {
		return "login";
	}
	
	@GetMapping("/welcome")
	public String afterlogin(){
		return "home";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	@GetMapping("/admin")
	@ResponseBody
	public String messageAfterLogin()
	{
		return "before login <br> please hit localhost:8080/login ";
	}
	
	@GetMapping("/admin/review")
	@ResponseBody
	public String adminReview()
	{
		return "Valid Username and Password";
	}
	
	
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo)
	{
		return service.addUser(userInfo);
	}
	

	

}
