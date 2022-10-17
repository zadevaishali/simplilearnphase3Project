package com.project.sporty_shoes.exception;

@SuppressWarnings("serial")
public class UsernameExistException extends Exception
{
   public UsernameExistException(String message)
   {
	   super(message);
   }
}
