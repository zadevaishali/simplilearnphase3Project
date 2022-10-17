package com.project.sporty_shoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
private String emailId;
private String password;
public LoginRequestDto() {
	// TODO Auto-generated constructor stub
}

public LoginRequestDto(String emailId, String password) {
	super();
	this.emailId = emailId;
	this.password = password;
}

public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
