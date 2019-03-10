package com.bookmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bookmanagement.model.Book;
import com.bookmanagement.service.BookService;

@Controller
@RequestMapping(value="/customer")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list() {
	ModelAndView model = new ModelAndView("customer/list");
	List<Book> list = bookService.listAllBook();
	model.addObject("list",list);
	return model;
	
	}
	@RequestMapping(value="/update/{id}",method = RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id){
		
	ModelAndView model = new ModelAndView("customer/form");
	Book book = bookService.findBookById(id);
	model.addObject("customerForm",book);
	
	return model;
	
	}
	
	@RequestMapping(value="/add",method = RequestMethod.GET)
	public ModelAndView update(){
		
	ModelAndView model = new ModelAndView("customer/form");
	Book book = new Book();
	model.addObject("customerForm",book);
	
	return model;
	
	}
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("customerForm")Book book){
		
	ModelAndView model = new ModelAndView("customer/form");
	bookService.saveOrUpdate(book);
	
	return new ModelAndView("redirect:/customer/list");
	
	}
	
}
