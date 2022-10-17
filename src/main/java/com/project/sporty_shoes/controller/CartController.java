package com.project.sporty_shoes.controller;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.sporty_shoes.dto.CartDto;
import com.project.sporty_shoes.exception.CartItemNotFoundException;
import com.project.sporty_shoes.model.Cart;
import com.project.sporty_shoes.response.ApiResponse;
import com.project.sporty_shoes.service.CartService;

@RestController
@RequestMapping(path = { "/cart" })
public class CartController {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public CartService cartService;

	@GetMapping
	public List<CartDto> getAllCartItems() {
		return cartService.getAllCartItems().stream().map(cartItem -> modelMapper.map(cartItem, CartDto.class))
				.collect(Collectors.toList());
	}

	@PostMapping
	public ResponseEntity<CartDto> addCartItem(@RequestBody CartDto cartDto) {
		Cart cartRequest = modelMapper.map(cartDto, Cart.class);
		Cart cart = cartService.addCartItem(cartRequest);
		CartDto cartResponse = modelMapper.map(cart, CartDto.class);
		return new ResponseEntity<>(cartResponse, CREATED);

	}

	@PutMapping("/{id}")
	public ResponseEntity<CartDto> updateCartItem(@PathVariable(name = "id") String id, @RequestBody CartDto cartDto)
			throws CartItemNotFoundException {
		Cart cartRequest = modelMapper.map(cartDto, Cart.class);
		Cart cart = cartService.updateCartItem(Integer.parseInt(id), cartRequest);
		CartDto cartResponse = modelMapper.map(cart, CartDto.class);
		return ResponseEntity.ok().body(cartResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse> deleteShoes(@PathVariable int id) {
		cartService.deleteCartItem(id);
		ApiResponse apiResponse = new ApiResponse();
		return new ResponseEntity<>(apiResponse, OK);
	}
}

