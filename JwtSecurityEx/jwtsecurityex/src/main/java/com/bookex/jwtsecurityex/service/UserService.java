package com.bookex.jwtsecurityex.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookex.jwtsecurityex.entity.UserEntity;
import com.bookex.jwtsecurityex.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserEntity createLoginCredentials(UserEntity userEntity) throws Exception {
		Optional<UserEntity> userEntityOP = userRepository.findByUserEmail(userEntity.getUserEmail());
		if(userEntityOP.isPresent() && userEntityOP.get().getUserEmail()!=null) {
			throw new Exception("OOPs! User Already There, please check once again.");
		}else {
			userRepository.save(userEntity);
		}
		return userEntity;
		
	}

	public List<UserEntity> getAllUsersCredentials() { 
		return userRepository.findAll();
	}
}
