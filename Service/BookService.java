package com.bookmanagement.service;

import java.util.List;

import com.bookmanagement.model.Book;

public interface BookService {
	
public List<Book> listAllBook();
	
	public void saveOrUpdate(Book book);
	
	public Book findBookById(int id);
	
	public void deleteBook(int id);
	
	
	
		

}
