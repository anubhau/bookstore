package com.fdmgroup.bookstore.data;

import com.fdmgroup.bookstore.model.Book;

public interface BookRepository extends Removable<Book>, Persistable<Book>, Searchable<Book> {

}
