package com.mscgift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mscgift.entity.Users;
import com.mscgift.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService{

	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Users registerUser(Users users) {
		
		String password = users.getPassword();
	    users.setPassword(passwordEncoder.encode(password));
		
		Users savedUser = usersRepository.save(users);
		return savedUser;
	}

}
