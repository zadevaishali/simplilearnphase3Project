package com.project.sporty_shoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
	private int orderId;
	private UserDto user;
	private int totalPrice;
	private String status;
	private String shoes;
	public OrderDto() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDto(int orderId, UserDto user, int totalPrice, String status, String shoes) {
		super();
		this.orderId = orderId;
		this.user = user;
		this.totalPrice = totalPrice;
		this.status = status;
		this.shoes = shoes;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getShoes() {
		return shoes;
	}
	public void setShoes(String shoes) {
		this.shoes = shoes;
	}
	
}