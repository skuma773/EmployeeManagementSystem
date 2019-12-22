package com.test.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
