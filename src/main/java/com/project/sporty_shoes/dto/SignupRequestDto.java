package com.project.sporty_shoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequestDto {
	private String username;
	private String emailId;
	private String password;
	private String mobileNumber;
	private String role;
	public SignupRequestDto() {
		// TODO Auto-generated constructor stub
	}
	
	public SignupRequestDto(String username, String emailId, String password, String mobileNumber, String role) {
		super();
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
