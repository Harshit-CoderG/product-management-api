package com.campus.springboot_crud_mysql.service;

import org.springframework.stereotype.Service;

import com.campus.springboot_crud_mysql.entity.User;
import com.campus.springboot_crud_mysql.repository.RoleRepository;
import com.campus.springboot_crud_mysql.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	public UserService(UserRepository userRepository, RoleRepository roleRepository) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	
	public User saveUserService(User user) {
		return userRepository.saveAndFlush(user);
		
	}
	public User findUserByNameService(String username) {
		return userRepository.findByUsername(username).orElse(null);
		
	}
}
