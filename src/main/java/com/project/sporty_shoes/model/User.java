package com.project.sporty_shoes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private String username;
    private String emailId;
    private String password;
    private String mobileNumber;
    private String role;
    private String[] authorities;
    private boolean isactive;
    private boolean isNotLocked;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
	private List<Order> userOrders;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true)
    
    private List<Cart> userCart;
    
    public User() {
		 	}

	public User(String username, String emailId, String password, String mobileNumber, String role, boolean isactive,
			boolean isNotLocked) {
		super();
		this.username = username;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.role = role;
		this.isactive = isactive;
		this.isNotLocked = isNotLocked;
		
		
		if(this.role.equals("role_user"))
		{
			String[] userAuthoritites= {"shoes:read,cart:read,cart:update,cart:write,order:read,order:write"};
			
			this.setAuthorities(userAuthoritites);
		} else if (this.role.equals("role_admin")) {
			String[] adminAuthoritites = { "shoes:read, shoes:write, cart:update, order:read" };
			this.setAuthorities(adminAuthoritites);
		}
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

	public String[] getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String[] authorities) {
		this.authorities = authorities;
	}

	public boolean isIsactive() {
		return isactive;
	}

	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}

	public boolean isNotLocked() {
		return isNotLocked;
	}

	public void setNotLocked(boolean isNotLocked) {
		this.isNotLocked = isNotLocked;
	}

	public List<Order> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(List<Order> userOrders) {
		this.userOrders = userOrders;
	}

	public List<Cart> getUserCart() {
		return userCart;
	}

	public void setUserCart(List<Cart> userCart) {
		this.userCart = userCart;
	}

	

		
}

    
    
    
    
