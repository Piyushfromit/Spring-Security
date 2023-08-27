package com.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.security.entity.Users;
import com.security.repository.UserRepository;
import com.security.service.UserService;


@RestController
public class UserController {
	
	
	
	@GetMapping("/user")
	public String userProcess() {
		return "<h1>Welcome User : </h1>";
	}
	
	
	
	
	
	
	
	
	

}
