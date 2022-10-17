package com.project.sporty_shoes.service;

import java.io.IOException;

import com.project.sporty_shoes.exception.EmailExistException;
import com.project.sporty_shoes.exception.UserNotFoundException;
import com.project.sporty_shoes.exception.UsernameExistException;
import com.project.sporty_shoes.model.User;

public interface UserService {

	User register(User user) throws UserNotFoundException, UsernameExistException, EmailExistException;

	User findUserByUsername(String username);

	User findUserByEmailId(String emailId);

	User addNewUser(User user) throws UserNotFoundException, UsernameExistException, EmailExistException, IOException;

	void deleteUser(int id) throws UserNotFoundException;
}
