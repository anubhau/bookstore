package com.fdmgroup.bookstore.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.bookstore.data.BookRepository;
import com.fdmgroup.bookstore.data.OrderRepository;
import com.fdmgroup.bookstore.data.UserRepository;
import com.fdmgroup.bookstore.exception.ItemNotFoundException;
import com.fdmgroup.bookstore.exception.UserNotFoundException;
import com.fdmgroup.bookstore.model.Book;
import com.fdmgroup.bookstore.model.Order;
import com.fdmgroup.bookstore.model.User;

public class OrderingService {
	OrderRepository orderRepository;
	BookService bookService;
	AuthenticationService authenticationService;
	private static int orderId = 1;

	public OrderingService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	public OrderingService(OrderRepository orderRepository,
			BookRepository bookRepository,
			UserRepository userRepository) {
		super();
		this.orderRepository = orderRepository;
		this.bookService = new BookService(bookRepository);
		this.authenticationService = new AuthenticationService(userRepository);
	}
	

	public static int generateOrderId() {
		return orderId++;
	}

	public Order placeOrder(Book book, User customer) {
		try {
			bookService.findById(book.getItemid());			
		} catch(ItemNotFoundException e) {
			return null;
		}
		try {
			authenticationService.findById(customer.getUserId());			
		} catch(UserNotFoundException e) {
			return null;
		}
		int newOrderId = generateOrderId();
		LocalDateTime orderDateTime = LocalDateTime.now();
		Order order = new Order(newOrderId, book, customer.getUserId(), orderDateTime);
		return orderRepository.save(order);
	}

	public List<Order> placeOrders(List<Book> books, User customer)
			throws ItemNotFoundException, UserNotFoundException {
		authenticationService.findById(customer.getUserId());
		//Validate books and prepare order list
		Order order = null;
		List<Order> orders = new ArrayList<>();
		LocalDateTime orderDateTime = LocalDateTime.now();
		for (Book book : books) {
			bookService.findById(book.getItemid());
			order = new Order(generateOrderId(), book, customer.getUserId(), orderDateTime);
			orders.add(order);
		}
		// Save orders in repository
		for (Order item : orders) {
			orderRepository.save(item);
		}
		return orders;
	}	

	public List<Order> getOrdersForUser(User user) {
		List<Order> userOrders = new ArrayList<>();
		List<Order> orders = orderRepository.findAll();
		for (Order order : orders) {
			if(order.getUserId() == user.getUserId()) {
				userOrders.add(order);
			}
		}
		return userOrders;
	}

	public List<Order> getOrdersForBook(Book book) {
		List<Order> bookOrders = new ArrayList<>();
		List<Order> orders = orderRepository.findAll();
		for (Order order : orders) {
			if(order.getBookOrdered().getItemid() == book.getItemid()) {
				bookOrders.add(order);
			}
		}
		return bookOrders;
	}
	
}
