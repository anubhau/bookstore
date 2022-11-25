package com.fdmgroup.bookstore.service;

import com.fdmgroup.bookstore.data.UserRepository;
import com.fdmgroup.bookstore.exception.UserNotFoundException;
import com.fdmgroup.bookstore.model.User;

public class AuthenticationService {
	UserRepository userRepository;

	public AuthenticationService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	public User authenticate(String Username, String Password) throws UserNotFoundException {
		if (userRepository.validate(Username, Password) == true) {
			return (userRepository.findByUsername(Username));
		}
		else {
			throw new UserNotFoundException(); //throwing custom exception UserNotFoundException
		}
	}

	public User findById(int Id) throws UserNotFoundException {
		User user = userRepository.findById(Id);
		if (user != null) {
			return user;
		}
		else {
			throw new UserNotFoundException(); //throwing custom exception UserNotFoundException
		}
	}
	
}
