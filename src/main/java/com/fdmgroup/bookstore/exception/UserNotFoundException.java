package com.fdmgroup.bookstore.exception;

	public class UserNotFoundException extends Exception {
		
		public UserNotFoundException () {
			super("User not found!");
		}

	}
