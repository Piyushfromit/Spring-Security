package com.mscgift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mscgift.entity.Users;
import com.mscgift.service.UsersService;


@Controller
public class UserController {
	

	
//	@GetMapping("/")
//	@ResponseBody 
//	public String welcomeMessage() {
//		return "jai sree ram ";
//	}
	
	@GetMapping("/jsp")
	public String welcomeJspPage() {
		
		return "home";
	}
	
	@GetMapping("/user/jsp")
	public String userJspPage() {
		
		return "userjsp";
	}
	
	@GetMapping("/admin/jsp")
	public String adminJspPage() {
		
		return "adminjsp";
	}
	
	
	
	

	
	

}
