package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
	
    @GetMapping("/admin")
	public String adminProcess() {
		return "<h1>Welcome Admin : </h1>";
	}
	
	
	
	

}
