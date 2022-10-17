package com.project.sporty_shoes.service;
import java.util.List;
import com.project.sporty_shoes.exception.CartItemNotFoundException;
import com.project.sporty_shoes.model.Cart;
public interface CartService {
	public Cart getCartItemById(int cartItemId) throws CartItemNotFoundException;

	public List<Cart> getAllCartItems();

	public Cart addCartItem(Cart cartItem);

	public Cart updateCartItem(int cartItemId, Cart cartItem) throws CartItemNotFoundException;

	public void deleteCartItem(int cartItemId);

}

