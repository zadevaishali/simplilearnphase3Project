package com.project.sporty_shoes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.sporty_shoes.exception.OrderNotFoundException;
import com.project.sporty_shoes.model.Order;
import com.project.sporty_shoes.model.User;
import com.project.sporty_shoes.repository.OrderRepository;
import com.project.sporty_shoes.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	public OrderRepository orderRepository;

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public List<Order> getAllOrdersByUser(User user) {
		return orderRepository.findByUser(user);
	}

	@Override
	public Order getOrderById(int orderId) throws OrderNotFoundException {
		return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found"));
	}

	@Override
	public Order addOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
	}

}
