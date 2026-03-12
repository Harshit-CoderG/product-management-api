package com.campus.springboot_crud_mysql.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.campus.springboot_crud_mysql.entity.User;
import com.campus.springboot_crud_mysql.repository.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	private final UserRepository userRepository;
	
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Username not found with name "+username));
		return new UserDetailServices(user);
	}
	

}
