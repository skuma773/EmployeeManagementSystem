package com.test.auth;

public interface SecurityService {
	String findLoggedInUsername();

    void autoLogin(String username, String password);

}
