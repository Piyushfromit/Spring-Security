package com.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.UserInfo;
import com.springsecurity.repository.UserInfoRepository;

@Service
public class SpringService {
	
	
	@Autowired
	private UserInfoRepository userInfoRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String addUser(UserInfo userInfo)
	{
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepo.save(userInfo);
		return "User Added To System";
		
	}

}
