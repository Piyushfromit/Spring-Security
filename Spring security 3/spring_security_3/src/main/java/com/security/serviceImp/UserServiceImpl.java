package com.security.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.Authority;
import com.security.entity.Users;
import com.security.repository.AuthorityRepository;
import com.security.repository.UserRepository;
import com.security.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;
	
	
	@Autowired
    private AuthorityRepository roleRepository;
	
	
	
	@Override
	public Users saveUser(Users user) {
		// TODO Auto-generated method stub
		try {
			Authority roleClass = new Authority();
			roleClass.setEmail(user.getEmail());
			roleClass.setAuthority("ROLE_USER");
			userRepository.save(user);
			roleRepository.save(roleClass);
			return user;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
