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

	public int getOrderId() {
		return OrderId;
	}

	public void setOrderId(int orderId) {
		OrderId = orderId;
	}

	public Book getBookOrdered() {
		return bookOrdered;
	}

	public void setBookOrdered(Book bookOrdered) {
		this.bookOrdered = bookOrdered;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}
	
}
