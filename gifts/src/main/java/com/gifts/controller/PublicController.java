package com.gifts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gifts.entity.UserInfo;
import com.gifts.service.SpringService;

@Controller
public class PublicController {


	@Autowired
	private SpringService service;
	
	@GetMapping("/")
	@ResponseBody
	public String firstMessage()
	{
		return "Hello This is first message piyush";
	}
	
	@GetMapping("/message")
	@ResponseBody
	public String message()
	{
		return " message piyush";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String admin()
	{
		return "Hello Admin";
	}
	
	@GetMapping("/user")
	@ResponseBody
	public String user()
	{
		return "Hello user";
	}
	
	@GetMapping("admin/review")
	@ResponseBody
	public String adminReview()
	{
		return "Valid Username and Password";
	}
	@PostMapping("/new")
	@ResponseBody
	public String addNewUser(@RequestBody UserInfo userInfo)
	{
		return service.addUser(userInfo);
		
	}
}
