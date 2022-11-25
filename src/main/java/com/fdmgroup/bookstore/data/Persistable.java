package com.fdmgroup.bookstore.data;

public interface Persistable <T> {
	
	public T save(T t);

}