package com.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springsecurity.entity.UserInfo;
import com.springsecurity.service.SpringService;

@RestController
public class AdminController {
	
	@Autowired
	private SpringService service;
	
	@GetMapping("/admin")
	public String admin()
	{
		return "Hello User";
	}
	@GetMapping("admin/review")
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
