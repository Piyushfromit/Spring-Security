package com.gifts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gifts.entity.UserInfo;
import com.gifts.repo.UserInfoRepository;

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
