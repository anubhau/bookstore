package com.fdmgroup.bookstore.data;

import java.util.List;

public interface Searchable <T>{
	
	public  T findById(int id);
	public  List<T> findAll();
	
}