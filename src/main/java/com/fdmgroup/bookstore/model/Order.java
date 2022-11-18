package com.fdmgroup.bookstore.model;

import java.time.LocalDateTime;

public class Order {

	
	private int OrderId;
	Book bookOrdered;
	private int userId;
	private LocalDateTime orderDateTime;
	
	public Order(int orderId, Book bookOrdered, int userId, LocalDateTime orderDateTime) {
		super();
		OrderId = orderId;
		this.bookOrdered = bookOrdered;
		this.userId = userId;
		this.orderDateTime = orderDateTime;
	}
	
	
	
}
