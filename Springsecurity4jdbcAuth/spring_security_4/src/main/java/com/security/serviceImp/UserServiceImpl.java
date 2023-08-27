package com.security.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Users registerUser(Users user) {
		
		user.setEnabled(1);
		Authority roleClass = new Authority();
		roleClass.setEmail(user.getEmail());
		roleClass.setAuthority("ROLE_USER");
		String password = user.getPassword();
		user.setPassword(passwordEncoder.encode(password));
		userRepository.save(user);
		roleRepository.save(roleClass);
		return user;
	}

	

}
