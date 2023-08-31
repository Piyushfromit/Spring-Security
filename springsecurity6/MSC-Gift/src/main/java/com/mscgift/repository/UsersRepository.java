package com.mscgift.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mscgift.entity.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{

//	Optional<Users> findByName(String username);
	
	Optional<Users> findByEmail(String email);
	
	
}
