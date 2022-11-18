package com.fdmgroup.bookstore.data;

import com.fdmgroup.bookstore.model.User;

public interface UserRepository extends Persistable, Removable, Searchable {
	public boolean validate(String udername,String password);
	
	
	public User findByUsername(String username);
	
	

}
