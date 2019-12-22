package com.test.auth;

import com.test.entity.User;

public interface UserService {
	
	void save(User user);

    User findByUsername(String username);

}
