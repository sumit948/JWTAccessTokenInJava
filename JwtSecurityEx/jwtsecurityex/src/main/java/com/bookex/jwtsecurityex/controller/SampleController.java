package com.bookex.jwtsecurityex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookex.jwtsecurityex.entity.UserEntity;
import com.bookex.jwtsecurityex.service.UserService;

@RestController
@RequestMapping("/login")
public class SampleController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signUp")
	public UserEntity createLoginCredentials(@RequestBody UserEntity userEntity) throws Exception {
		
		 return userService.createLoginCredentials(userEntity);
	}
	
	@GetMapping("/getAllUsersLoginCredentials")
	public List<UserEntity> getAllUsersCredentials(){
		return userService.getAllUsersCredentials();
	}
	
	
}
