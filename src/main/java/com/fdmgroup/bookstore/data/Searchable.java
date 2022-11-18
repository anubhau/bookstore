package com.fdmgroup.bookstore.data;

import java.util.List;

import com.fdmgroup.bookstore.model.User;

public interface Searchable {
	public User findById(int id);
	public List<User> findAll();
	

}
