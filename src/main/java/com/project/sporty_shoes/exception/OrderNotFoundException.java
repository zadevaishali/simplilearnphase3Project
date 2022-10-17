package com.project.sporty_shoes.exception;

@SuppressWarnings("serial")
public class OrderNotFoundException extends Exception {

	public OrderNotFoundException(String message)
	{
		super(message);
	}
}
