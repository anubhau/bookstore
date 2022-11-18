package com.fdmgroup.bookstore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.fdmgroup.bookstore.data.UserArrayListRepository;
import com.fdmgroup.bookstore.model.Book;
import com.fdmgroup.bookstore.model.BookGenre;
import com.fdmgroup.bookstore.model.Order;
import com.fdmgroup.bookstore.model.User;

/**
 * Unit test for UserArrayListRepository.
 */
public class UserArrayListRepositoryTest 
{

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
	UserArrayListRepository ualr1, ualr2;
	

	@Before
	public void setUp() throws Exception {
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

		users = new ArrayList<User>();
		ualr1 = new UserArrayListRepository(users);
	}

	@Test
	public void testValidate() {
		User user3 = new User("ANUBHA3", "UPADH3", "username3", "password3", "3anubhau@gmail.com", orders3);
		users.add(user3);
		assertTrue(ualr1.validate("username3", "password3"));
	}

	@Test
	public void testFindByUsername() {
		users.add(user1);
		assertEquals(ualr1.findByUsername("username").getFirstName(), "ANUBHA");
		assertNull(ualr1.findByUsername("xxxxx"));
	}

	@Test
	public void testSave() {
		User user3 = new User("ANUBHA3", "UPADH3", "username3", "password3", "3anubhau@gmail.com", orders3);
		ualr1.save(user3);
		System.out.println(ualr1);
		assertEquals(ualr1.findByUsername("username3").getFirstName(), "ANUBHA3");
	}

	@Test
	public void testDelete() {
		User user3 = new User("ANUBHA3", "UPADH3", "username3", "password3", "3anubhau@gmail.com", orders3);
		ualr1.save(user3);
		assertNotNull(ualr1.findByUsername("username3"));
		ualr1.delete(user3);
		assertNull(ualr1.findByUsername("username3"));
	}

	@Test
	public void testGenerateId() {
		int i = UserArrayListRepository.generateId();
		int j = UserArrayListRepository.generateId();
		assertEquals(j, i + 1);
	}

	@Test
	public void testFindById() {
		int i = UserArrayListRepository.generateId();
		User user3 = new User("ANUBHA3", "UPADH3", "username3", "password3", "3anubhau@gmail.com", orders3);
		ualr1.save(user3);
		assertEquals(ualr1.findById(i + 1).getUsername(), "username3");
	}

	@Test
	public void testFindAll() {
		users.add(user1);
		users.add(user2);
		assertEquals(ualr1.findAll().size(), 2);
	}

}
