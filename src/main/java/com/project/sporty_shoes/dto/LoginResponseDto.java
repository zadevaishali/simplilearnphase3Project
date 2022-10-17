package com.project.sporty_shoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
	private int id;
	private String username;
	private String emailId;
	private String mobileNumber;
	private String role;
	private boolean isActive;
	private boolean isNotLocked;
	public LoginResponseDto() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginResponseDto(int id, String username, String emailId, String mobileNumber, String role, boolean isActive,
			boolean isNotLocked) {
		super();
		this.id = id;
		this.username = username;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.isActive = isActive;
		this.isNotLocked = isNotLocked;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean isNotLocked() {
		return isNotLocked;
	}
	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}
	
}
