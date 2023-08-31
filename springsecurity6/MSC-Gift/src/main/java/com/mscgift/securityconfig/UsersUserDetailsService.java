package com.mscgift.securityconfig;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mscgift.entity.Users;
import com.mscgift.repository.UsersRepository;



@Service
public class UsersUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		// Optional<Users> users = usersRepository.findByName(username);
		
		Optional<Users> users = usersRepository.findByEmail(username);
		
		return users.map(UsersUserDetails::new)
				.orElseThrow(()->new UsernameNotFoundException("User Not Found "+username));
		
	}

}
