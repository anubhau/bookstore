package com.fdmgroup.bookstore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
//import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.fdmgroup.bookstore.data.UserArrayListRepository;
import com.fdmgroup.bookstore.data.UserRepository;
import com.fdmgroup.bookstore.exception.UserNotFoundException;
import com.fdmgroup.bookstore.model.Book;
import com.fdmgroup.bookstore.model.BookGenre;
import com.fdmgroup.bookstore.model.Order;
import com.fdmgroup.bookstore.model.User;
import com.fdmgroup.bookstore.service.AuthenticationService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
	import java.util.Arrays;
import java.util.List;

public class AuthenticationServiceTest {
		
		AuthenticationService as1;
		
		@Mock                          
		UserRepository urMock;
		Book b1;
		Book b2;
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
			b1 = new Book(BookGenre.CRIME, 10, 10.90, "anu", "bhanu");
			b2 = new Book(BookGenre.THRILLER, 11, 12.90, "anujn", "bhanujn");

			o1 = new Order(1, b1, 23, LocalDateTime.of(2019, Month.MARCH, 28, 14, 33, 48, 000000));
			o2 = new Order(1, b2, 22, LocalDateTime.of(2017, Month.MAY, 27, 11, 31, 49, 000000));
			o3 = new Order(1, b2, 22, LocalDateTime.of(2017, Month.MAY, 27, 11, 31, 49, 000000));

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
		public void testAuthenticate() throws UserNotFoundException {
			when(urMock.validate("username", "password")).thenReturn(true);
			when(urMock.findByUsername("username")).thenReturn(user1);
			as1 = new AuthenticationService(urMock);
			User user = as1.authenticate("username", "password");
			assertEquals(user.getUsername(), "username");
			verify(urMock, times(1)).findByUsername("username");
			// Test Exception
			try {
				when(urMock.validate("username", "password")).thenReturn(false);
				as1.authenticate("username", "password");
				fail();
			} catch(UserNotFoundException e) {
			}
		}

		@Test
		public void testFindById() throws UserNotFoundException {
			when(urMock.findById(100)).thenReturn(user1);
			as1 = new AuthenticationService(urMock);
			User user = as1.findById(100);
			assertEquals(user.getUsername(), "username");
			verify(urMock, times(1)).findById(100);
			// Test Exception
			try {
				when(urMock.findById(100)).thenReturn(null);
				as1.findById(100);
				fail();
			} catch(UserNotFoundException e) {
			}
		}
		
}