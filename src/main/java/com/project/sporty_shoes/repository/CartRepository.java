package com.project.sporty_shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sporty_shoes.model.Cart;
import com.project.sporty_shoes.model.User;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	public Cart findByUser(User user);
}
