package com.bookmanagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bookmanagement.model.Book;


@Repository
public class BookDAOImpl implements BookDAO  {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession() {
		
		return sessionFactory.getCurrentSession();
	}
	@SuppressWarnings("unchecked")
	public List<Book> listAllBook() {
		
		Criteria criteria = getSession().createCriteria(Book.class);
		return (List<Book>)criteria.list() ;
	}

	public void saveOrUpdate(Book book) {
	getSession().saveOrUpdate(book);
		
	}

	public Book findBookById(int id) {
	Book book = (Book)getSession().get(Book.class, id);
		return book;
	}

	public void deleteBook(int id) {
		Book book = (Book)getSession().get(Book.class, id);
		getSession().delete(book);
 
		
	}
	
	
	//@Autowired
//	private SessionFactory sessionFactory;
//
//	public long save(Book book) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public Book get(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public List<Book> list() {
//		
//		List<Book> list = sessionFactory.getCurrentSession().createQuery("from Book").list();
//		return list;
//	}
//
//	public void update(long id, Book book) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void delete(long id) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
//	
//
}
