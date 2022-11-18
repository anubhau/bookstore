package com.fdmgroup.bookstore.model;

public class EBook extends Book{

	public EBook(BookGenre b1, int itemid, double price, String title, String author) {
		super(b1, itemid, price, title, author);
		// TODO Auto-generated constructor stub
	}

	private double sizeMegaBytes;
}
