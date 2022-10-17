package com.project.sporty_shoes.service;


	
	import java.util.List;

	import com.project.sporty_shoes.exception.OrderNotFoundException;
	import com.project.sporty_shoes.model.Order;
	import com.project.sporty_shoes.model.User;

	public interface OrderService {

		public List<Order> getAllOrders();

		public List<Order> getAllOrdersByUser(User user);

		public Order getOrderById(int orderId) throws OrderNotFoundException;

		public Order addOrder(Order order);

		public void deleteOrder(int orderId);

	}


