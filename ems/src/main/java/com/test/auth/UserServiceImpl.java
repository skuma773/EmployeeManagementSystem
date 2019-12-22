package com.test.auth;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.auth.repository.RoleRepository;
import com.test.auth.repository.UserRepository;
import com.test.entity.Role;
import com.test.entity.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findTop1ById(2);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(new HashSet<>(roles));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
