package com.bs.service;


import java.util.List;

import com.bs.entity.Book;

public interface BookServiceinterface {
	void save(Book b);
    List<Book> getAllBooks();
    Book getBookById(int id);
    void deleteById(int id);
}
