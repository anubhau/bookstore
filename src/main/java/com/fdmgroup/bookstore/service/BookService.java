package com.fdmgroup.bookstore.service;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.bookstore.data.BookRepository;
import com.fdmgroup.bookstore.exception.ItemNotFoundException;
import com.fdmgroup.bookstore.model.Book;
import com.fdmgroup.bookstore.model.BookGenre;

public class BookService {
	BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public List<Book> getBooksOfGenre(BookGenre bookGenre) {
		List<Book> genreBooks = new ArrayList<>();
		List<Book> books = bookRepository.findAll();
		for(Book item : books) {
			if(item.getB1().equals(bookGenre)) {
				genreBooks.add(item);
			}
		}
		return genreBooks;
	}
	
	public List<Book> searchBooksByTitle(String title) {
		List<Book> titleBooks = new ArrayList<>();
		List<Book> books = bookRepository.findAll();
		for(Book item : books) {
			if(item.getTitle().equals(title)) {
				titleBooks.add(item);
			}
		}
		return titleBooks;
	}
	
	public List<Book> searchBooksByAuthorName(String bookAuthorNameToSearch) {
		List<Book> authorBooks = new ArrayList<>();
		List<Book> books = bookRepository.findAll();
		for(Book item : books) {
			if(item.getAuthor().toLowerCase().contains(bookAuthorNameToSearch.toLowerCase())) {
				authorBooks.add(item);
			}
		}
		return authorBooks;
	}

	public Book findById(int Id) throws ItemNotFoundException {
		Book book = bookRepository.findById(Id);
		if (book != null) {
			return book;
		}
		else {
			throw new ItemNotFoundException();
		}
	}
	
}
