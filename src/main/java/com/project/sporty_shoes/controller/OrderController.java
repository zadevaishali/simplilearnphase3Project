package com.project.sporty_shoes.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.sporty_shoes.dto.OrderDto;
import com.project.sporty_shoes.model.Order;
import com.project.sporty_shoes.model.User;
import com.project.sporty_shoes.response.ApiResponse;
import com.project.sporty_shoes.service.OrderService;
import com.project.sporty_shoes.service.UserService;

@RestController
@RequestMapping
public class OrderController {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public OrderService orderService;

	@Autowired
	public UserService userService;

	@GetMapping(path = { "/admin/orders" })
	public List<OrderDto> getAllOrders() {
		return orderService.getAllOrders().stream().map(order -> modelMapper.map(order, OrderDto.class))
				.collect(Collectors.toList());
	}

	@GetMapping(path = { "/orders" })
	public List<OrderDto> getAllOrdersByUser() {
		String userPrincipalName = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userService.findUserByUsername(userPrincipalName);
		return orderService.getAllOrdersByUser(user).stream().map(order -> modelMapper.map(order, OrderDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping(path = { "/order" })
	public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
		Order orderRequest = modelMapper.map(orderDto, Order.class);
		Order order = orderService.addOrder(orderRequest);
		OrderDto orderResponse = modelMapper.map(order, OrderDto.class);
		return new ResponseEntity<>(orderResponse, CREATED);
	}

	@DeleteMapping(path = { "/orders/{id}" })
	public ResponseEntity<ApiResponse> deleteOrder(@PathVariable(name = "id") int orderId) {
		orderService.deleteOrder(orderId);
		ApiResponse apiResponse = new ApiResponse();
		return new ResponseEntity<>(apiResponse, OK);
	}

}
