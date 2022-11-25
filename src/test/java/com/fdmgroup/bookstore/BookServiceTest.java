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

import com.fdmgroup.bookstore.data.BookRepository;
import com.fdmgroup.bookstore.data.UserArrayListRepository;
import com.fdmgroup.bookstore.data.UserRepository;
import com.fdmgroup.bookstore.exception.ItemNotFoundException;
import com.fdmgroup.bookstore.exception.UserNotFoundException;
import com.fdmgroup.bookstore.model.Book;
import com.fdmgroup.bookstore.model.BookGenre;
import com.fdmgroup.bookstore.model.Order;
import com.fdmgroup.bookstore.model.User;
import com.fdmgroup.bookstore.service.AuthenticationService;
import com.fdmgroup.bookstore.service.BookService;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
	import java.util.Arrays;
import java.util.List;

public class BookServiceTest {
		
		BookService bs1;
		
		@Mock                          
		BookRepository brMock;
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
			brMock =  mock(BookRepository.class);
			b1 = new Book(BookGenre.CRIME, 10, 10.90, "anu", "bhanu");
			b2 = new Book(BookGenre.THRILLER, 11, 12.90, "anujn", "bhanujn");
			b3 = new Book(BookGenre.ACTION, 10, 10.90, "anu", "bhanu");
			books = new ArrayList<>();
			
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
		public void testGetAllBooks() {
			books.clear();
			books.add(b1);
			when(brMock.findAll()).thenReturn(books);
			bs1 = new BookService(brMock);
			List<Book> books = bs1.getAllBooks();
			assertEquals(books.size(), 1);
		}

		@Test
		public void testGetBooksOfGenre() {
			books.clear();
			books.add(b1);
			books.add(b2);
			books.add(b3);
			when(brMock.findAll()).thenReturn(books);
			bs1 = new BookService(brMock);
			List<Book> genreBooks = bs1.getBooksOfGenre(BookGenre.ACTION);
			assertEquals(genreBooks.size(), 1);
		}

		@Test
		public void testSearchBooksByTitle() {
			books.clear();
			books.add(b1);
			books.add(b2);
			books.add(b3);
			when(brMock.findAll()).thenReturn(books);
			bs1 = new BookService(brMock);
			List<Book> titleBooks = bs1.searchBooksByTitle("anu");
			assertEquals(titleBooks.size(), 2);
		}

		@Test
		public void testSearchBooksByAuthorName() {
			books.clear();
			books.add(b1);
			books.add(b2);
			books.add(b3);
			when(brMock.findAll()).thenReturn(books);
			bs1 = new BookService(brMock);
			List<Book> authorBooks = bs1.searchBooksByAuthorName("bhanu");
			assertEquals(authorBooks.size(), 3);
		}

		@Test
		public void testFindById() throws ItemNotFoundException {
			b1.setItemid(100);
			when(brMock.findById(100)).thenReturn(b1);
			bs1 = new BookService(brMock);
			Book book = bs1.findById(100);
			assertEquals(book.getItemid(), 100);

			// Test Exception
			try {
				when(brMock.findById(100)).thenReturn(null);
				bs1.findById(100);
				fail();
			} catch(ItemNotFoundException e) {
			}
		}
		
}