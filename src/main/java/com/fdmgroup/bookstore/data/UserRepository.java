package com.fdmgroup.bookstore.data;

import com.fdmgroup.bookstore.model.User;

public interface UserRepository extends Searchable<User> {
	public boolean validate(String udername,String password);
	
	public User findByUsername(String username);

}
