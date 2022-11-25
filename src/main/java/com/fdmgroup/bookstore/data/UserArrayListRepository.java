package com.fdmgroup.bookstore.data;

import java.util.ArrayList;

import java.util.List;

import com.fdmgroup.bookstore.model.Book;
import com.fdmgroup.bookstore.model.Order;
import com.fdmgroup.bookstore.model.User;

public class UserArrayListRepository implements UserRepository {

	private static int id = 1;

	private List<User> users;

	public UserArrayListRepository() {
	}

	public UserArrayListRepository(List<User> users) {
		this.users = users;
	}

	public boolean validate(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public User findByUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username))
				return user;
		}
		return null;
	}

	public static int generateId() {
		return id++;
	}

	public User save(User user) {
		boolean isOldUser = false;
		User matchOldUser = null;
		for (User oldUser : users) {
			if (oldUser.getUsername().equals(user.getUsername())) {
				isOldUser = true;
				matchOldUser = oldUser;
				break;
			}
		}
		if (!isOldUser) {
			int userId = generateId();
			user.setUserId(userId);
			users.add(user);
		} else {
			user.setUserId(matchOldUser.getUserId());
			users.remove(matchOldUser);
			users.add(user);
		}
		return user;
	}

	public User delete(User user) {
		boolean isOldUser = false;
		User matchOldUser = null;
		for (User oldUser : users) {
			if (oldUser.getUsername().equals(user.getUsername())) {
				isOldUser = true;
				matchOldUser = oldUser;
				break;
			}
		}
		if (isOldUser) {
			users.remove(matchOldUser);
		}
		return null;
	}

	public User findById(int id) {
		for (User user : users) {
			if (user.getUserId() == id)
				return user;
		}
		return null;
	}

	public List<User> findAll() {
		return users;
	}
  
	//input a price and list of all books are returned whoch are more expensive than this price
   // Book b=new Book(null, 0, 0, null, null);
/*	public List <Book> morepricethanthis(int price)
	{
	List<Book>allBooks=new ArrayList<>();
	List<Book>books=b.getallBooks();;
	for(Book b:books)
	{
		
		books.geallBooks();
		newprice=b.getPrice();
		if(newprice>price)
			allBooks=books.add(e);
	}
	return allBokks;
	}
	/*
 //return the list of all books by an author
	//public List<Book> getAllBooks(String author){
		//List<Book> allBooks=new ArrayList();
	      //List<Book> userBooks = null;
		//for(Book each:book)
		//{
			
		//if((each.getAuthor).equals(author))
		//return(getallbooks(author));
		//}	
	
	*/

	
	
	public List<Book> getAllBooks(String author) {
		List<Book> allBooks = new ArrayList<>();
		List<Book> userBooks = null;
		
		for(User user : users) {
			userBooks = user.getUserBooks(author);
			for(Book userBook : userBooks) {
				if(!allBooks.contains(userBook)) {
					allBooks.add(userBook);
				}
			}
		}
		return allBooks;
	}
	
	
}

	

	
	
	
	


