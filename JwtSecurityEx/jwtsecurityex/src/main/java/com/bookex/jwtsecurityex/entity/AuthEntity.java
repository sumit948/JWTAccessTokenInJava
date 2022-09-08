package com.bookex.jwtsecurityex.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthEntity {

	private String userName;
	
	private String password;
}
