package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


import com.springsecurity.entity.UserInfo;
import com.springsecurity.service.SpringService;

@Controller
public class AdminController {
	
	@Autowired
	private SpringService service;
	
	
	// First hit localhost:8080/login
	
	@GetMapping("/")
	@ResponseBody
	public String messageAfterLogin()
	{
		return "before login <br> please hit localhost:8080/login ";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin()
	{
		return "Hello User I am Admin";
	}
	
	@GetMapping("admin/review")
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
