package com.project.sporty_shoes.exception;

@SuppressWarnings("serial")
public class EmailExistException extends Exception{

	public EmailExistException (String message)
	{
		super(message);
	}
}
