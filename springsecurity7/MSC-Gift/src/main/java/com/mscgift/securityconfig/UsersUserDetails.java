package com.mscgift.securityconfig;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mscgift.entity.Users;





public class UsersUserDetails implements UserDetails{

	private String email;
	private String password;
	private Boolean enabled;
	private List<GrantedAuthority> authorities;
	
	
	public UsersUserDetails(Users users) {
		email= users.getEmail();
		password = users.getPassword();
		enabled = users.getIsEnabled();
		authorities= Arrays.stream(users.getRoles().split(","))
				.map(SimpleGrantedAuthority::new)
	    		.collect(Collectors.toList());
		
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		 return enabled;
	}

	
	
	
	
}
