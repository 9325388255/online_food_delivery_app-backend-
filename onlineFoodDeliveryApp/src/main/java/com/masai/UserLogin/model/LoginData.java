package com.masai.UserLogin.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class LoginData {
	
	@Id
	private Integer userId;
	
	private String userName;
	
	private String password;

}
