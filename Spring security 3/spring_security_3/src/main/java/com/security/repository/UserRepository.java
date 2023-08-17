package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.security.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	Optional<Users>  findByEmail (final String email);
	
	
	

}
