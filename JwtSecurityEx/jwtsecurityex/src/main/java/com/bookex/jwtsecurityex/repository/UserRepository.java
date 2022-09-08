package com.bookex.jwtsecurityex.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookex.jwtsecurityex.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	UserEntity findByUserName(String username);

	Optional<UserEntity> findByUserEmail(String userEmail);

}
