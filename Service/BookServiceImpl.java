package com.bookmanagement.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmanagement.dao.BookDAO;
import com.bookmanagement.model.Book;

@Service
@Transactional
public class BookServiceImpl  implements BookService {

	
	BookDAO bookDao;
	@Autowired
	
	public void setBookDAO(BookDAO bookDao)
	{
		this.bookDao = bookDao;
	}
	
	public List<Book> listAllBook() {
	
		return bookDao.listAllBook();
	}

	public void saveOrUpdate(Book book) {
		bookDao.saveOrUpdate(book);
		
	}

	public Book findBookById(int id) {
		
		return bookDao.findBookById(id);
	}

	public void deleteBook(int id) {
		
		bookDao.deleteBook(id);
	}
	
	

}
