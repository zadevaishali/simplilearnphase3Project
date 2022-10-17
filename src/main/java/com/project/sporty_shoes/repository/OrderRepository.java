package com.project.sporty_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.sporty_shoes.model.Order;
import com.project.sporty_shoes.model.User;

public interface OrderRepository extends JpaRepository<Order, Integer>  {
	public List<Order> findByUser(User user);

}
