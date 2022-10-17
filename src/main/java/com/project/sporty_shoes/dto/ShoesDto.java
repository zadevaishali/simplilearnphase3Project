package com.project.sporty_shoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoesDto {

	private int id;
	private String name;
	private int price;
	private int quantityAvailable;
	private String imageUrl;
	public ShoesDto() {
		// TODO Auto-generated constructor stub
	}
	
	public ShoesDto(int id, String name, int price, int quantityAvailable, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
