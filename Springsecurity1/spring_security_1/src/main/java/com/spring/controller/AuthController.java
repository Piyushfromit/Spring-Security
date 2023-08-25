package com.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AuthController {
	
	@GetMapping("/")
	@ResponseBody
	public String homePage() {
		
		return "<h1>Hello Dear Welcome to home page<h1>";
	}
	
	@GetMapping("/about")
	@ResponseBody
	public String aboutPage(){
		
		return "<h1>This is about page<h1>";
	}
	
	@GetMapping("/register")
	@ResponseBody
	public String registerPage(){
		return "<h1>This is Register Page </h1>";
	}
	
	@GetMapping("/admin")
	@ResponseBody
	public String adminPage(){
		return "<h1>This Is admin Page, You Are loged in Successfully</h1>";
	}
	
	

}
