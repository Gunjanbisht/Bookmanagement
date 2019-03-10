package com.bookmanagement.dao;

import java.util.List;

import com.bookmanagement.model.Book;

public interface BookDAO {
	
	public List<Book> listAllBook();
	
	public void saveOrUpdate(Book book);
	
	public Book findBookById(int id);
	
	public void deleteBook(int id);
	
	
	
//	//save the record
//	
//	long save (Book book);
//	
//	//Get a single record 
//	
//	Book get(long id);
//	
//	//Get all the records
//	List<Book> list();
//	
//	//Update the record
//	void update (long id,Book book);
//	
//	
//	//Delete a record
//	void delete(long id);
//	
//	
	

}
