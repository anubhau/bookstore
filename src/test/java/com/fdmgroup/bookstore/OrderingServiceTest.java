package com.fdmgroup.bookstore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.bookstore.data.BookRepository;
import com.fdmgroup.bookstore.data.OrderRepository;
import com.fdmgroup.bookstore.data.UserRepository;
import com.fdmgroup.bookstore.exception.ItemNotFoundException;
import com.fdmgroup.bookstore.exception.UserNotFoundException;
import com.fdmgroup.bookstore.model.Book;
import com.fdmgroup.bookstore.model.BookGenre;
import com.fdmgroup.bookstore.model.Order;
import com.fdmgroup.bookstore.model.User;
import com.fdmgroup.bookstore.service.OrderingService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class OrderingServiceTest {
		
		OrderingService os1;
		
		@Mock                          
		UserRepository urMock;
		@Mock
		BookRepository brMock;
		@Mock
		OrderRepository orMock;
		Book b1;
		Book b2;
		Book b3;
		List<Book> books;
		Order o1;
		Order o2;
		Order o3;
		List<Order> orders1;
		List<Order> orders2;
		List<Order> orders3;
		List<User> users;
		User user1;
		User user2;
		UserRepository ur1, ur2;

		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
		}
        
		@Before
		public void setUp() throws Exception {                         
			MockitoAnnotations.openMocks(this);
			urMock =  mock(UserRepository.class);
			brMock =  mock(BookRepository.class);
			orMock =  mock(OrderRepository.class);
			b1 = new Book(BookGenre.CRIME, 10, 10.90, "anu", "bhanu");
			b2 = new Book(BookGenre.THRILLER, 11, 12.90, "anujn", "bhanujn");
			b3 = new Book(BookGenre.ACTION, 12, 10.90, "anu", "bhanu");
			books = new ArrayList<>();
			
			o1 = new Order(1, b1, 23, LocalDateTime.of(2019, Month.MARCH, 28, 14, 33, 48, 000000));
			o2 = new Order(1, b2, 25, LocalDateTime.of(2017, Month.MAY, 27, 11, 31, 49, 000000));
			o3 = new Order(1, b3, 26, LocalDateTime.of(2017, Month.MAY, 27, 11, 31, 49, 000000));

			orders1 = new ArrayList<Order>();
			orders1.add(o1);
			orders2 = new ArrayList<Order>();
			orders2.add(o2);
			orders3 = new ArrayList<Order>();
			orders3.add(o3);
			user1 = new User("ANUBHA", "UPADH", "username", "password", "anubhau@gmail.com", orders1);
			user2 = new User("ANUBHA2", "UPADH2", "username2", "password2", "2anubhau@gmail.com", orders2);
		}
		

		@Test
		public void testPlaceOrder() {
			user1.setUserId(99);
			when(urMock.findById(99)).thenReturn(user1);
			when(brMock.findById(10)).thenReturn(b1);
			when(orMock.save(any())).thenReturn(o1);
			os1 = new OrderingService(orMock, brMock, urMock);
			Order order = os1.placeOrder(b1, user1);
			assertNotNull(order);
			// Test ItemNotFoundException
			when(brMock.findById(10)).thenReturn(null);
			order = os1.placeOrder(b1, user1);
			assertNull(order);
			// Test UserNotFoundException
			when(brMock.findById(10)).thenReturn(b1);
			when(urMock.findById(99)).thenReturn(null);
			order = os1.placeOrder(b1, user1);
			assertNull(order);
		}

		@Test
		public void testPlaceOrders() throws ItemNotFoundException, UserNotFoundException {
			user1.setUserId(99);
			books.add(b1);
			books.add(b2);
			books.add(b3);
			when(urMock.findById(99)).thenReturn(user1);
			when(brMock.findById(10)).thenReturn(b1);
			when(brMock.findById(11)).thenReturn(b2);
			when(brMock.findById(12)).thenReturn(b3);
			when(orMock.save(any())).thenReturn(o1);
			os1 = new OrderingService(orMock, brMock, urMock);
			List<Order> orders = os1.placeOrders(books, user1);
			assertEquals(orders.size(), 3);
		}

		@Test
		public void testGetOrdersForUser() {
			user1.setUserId(23);
			when(orMock.findAll()).thenReturn(orders1);
			os1 = new OrderingService(orMock);
			List<Order> orders = os1.getOrdersForUser(user1);
			assertEquals(orders.size(), 1);
		}

		@Test
		public void testGetOrdersForBook() {
			user1.setUserId(23);
			when(orMock.findAll()).thenReturn(orders1);
			os1 = new OrderingService(orMock);
			List<Order> orders = os1.getOrdersForBook(b1);
			assertEquals(orders.size(), 1);
		}
				
}