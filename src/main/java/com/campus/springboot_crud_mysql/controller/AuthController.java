package com.campus.springboot_crud_mysql.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campus.springboot_crud_mysql.dto.UserRequestDto;
import com.campus.springboot_crud_mysql.entity.User;
import com.campus.springboot_crud_mysql.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final PasswordEncoder passwordEncoder;

	private final AuthenticationManager authenticationManager;
	private final UserService userService;
	
	
	public AuthController(AuthenticationManager authenticationManager, UserService userService, PasswordEncoder passwordEncoder) {
		super();
		this.authenticationManager = authenticationManager;
		this.userService=userService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/register")
	public User saveUserController(@RequestBody User user) {
		
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return userService.saveUserService(user);
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUserController(@RequestBody UserRequestDto userRequest){
		
		Authentication authentication =authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				userRequest.getUsername(), userRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
        return ResponseEntity.ok("Login successful");
	}
}
