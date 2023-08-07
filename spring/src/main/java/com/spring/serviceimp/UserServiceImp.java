package com.spring.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.User;
import com.spring.repository.UserRepo;
import com.spring.service.UserService;


@Service
public class UserServiceImp  implements UserService{

	@Autowired
    private UserRepo userRepo;
	
	@Override
	public User regUser(User user) {
		if(user ==null) {
			// throw new StudentException("Student not registered");
			return user;
		}else {
			userRepo.save(user);
		}
		return user;
	}
	
	
	
	
	
	

}
