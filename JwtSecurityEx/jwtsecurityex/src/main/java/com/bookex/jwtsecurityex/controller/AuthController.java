package com.bookex.jwtsecurityex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookex.jwtsecurityex.entity.AuthEntity;

import com.bookex.jwtsecurityex.util.UserUtils;

@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserUtils userUtils;
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthEntity authEntity) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authEntity.getUserName(), authEntity.getPassword()));
		}catch(Exception w) {
			throw new Exception("Invalid Username/Password!!");
		}
		return userUtils.generateToken(authEntity.getUserName());
	}
}
