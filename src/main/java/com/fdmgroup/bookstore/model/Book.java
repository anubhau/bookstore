package com.fdmgroup.bookstore.model;

public class Book {

	@Override
	public String toString() {
		return "Book [b1=" + b1 + ", itemid=" + itemid + ", price=" + price + ", title=" + title + ", author=" + author
				+ "]";
	}
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((b1 == null) ? 0 : b1.hashCode());
		result = prime * result + itemid;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (b1 != other.b1)
			return false;
		if (itemid != other.itemid)
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
