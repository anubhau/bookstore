package com.fdmgroup.bookstore.model;

public class Book {

	private BookGenre b1;
	
	private int itemid;
	private double price;
	private String title;
	private String author;
	
	
	
	
	public Book(BookGenre b1, int itemid, double price, String title, String author) {
		super();
		this.b1 = b1;
		this.itemid = itemid;
		this.price = price;
		this.title = title;
		this.author = author;
	}
	/**
	 * @return the b1
	 */
	public BookGenre getB1() {
		return b1;
	}
	/**
	 * @param b1 the b1 to set
	 */
	public void setB1(BookGenre b1) {
		this.b1 = b1;
	}
	/**
	 * @return the itemid
	 */
	public int getItemid() {
		return itemid;
	}
	/**
	 * @param itemid the itemid to set
	 */
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
