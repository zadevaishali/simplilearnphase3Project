package com.project.sporty_shoes.dto;

import com.project.sporty_shoes.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
	private int id;
	private String shoesName;
	private int quantity;
	private int price;
	private int totalPrice;
	private String imageUrl;
	private User user;
	public CartDto() {
		// TODO Auto-generated constructor stub
	}
	
	public CartDto(int id, String shoesName, int quantity, int price, int totalPrice, String imageUrl, User user) {
		super();
		this.id = id;
		this.shoesName = shoesName;
		this.quantity = quantity;
		this.price = price;
		this.totalPrice = totalPrice;
		this.imageUrl = imageUrl;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShoesName() {
		return shoesName;
	}
	public void setShoesName(String shoesName) {
		this.shoesName = shoesName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
