package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
    @RequestMapping("/books") 
	public List<Book> getBooks() {
    	return bookService.getBooks();
    }

    @RequestMapping("/books/{isbn}") 
	public Book getBook(@PathVariable String isbn) {
    	return bookService.getBook(isbn);
    }

    @RequestMapping(
			method = RequestMethod.POST,  
			value = "/books"
	)
	public void addBook(@RequestBody Book book) {
    	bookService.addBook(book);
    }
    
    // Tallentaa myös kaikki mukana olevat tiedot ts. kustantaja sekä tekijät
    @RequestMapping(
			method = RequestMethod.POST,  
			value = "/books/all"
	)
	public void addBookAll(@RequestBody Book book) {
    	bookService.addBookAll(book);
    }
    
    @RequestMapping(
			method = RequestMethod.PUT,  
			value = "/books/{isbn}"
	)
	public void updateBook(@PathVariable String isbn, @RequestBody Book book) {
    	bookService.updateBook(isbn, book);
    }

    @RequestMapping(
			method = RequestMethod.DELETE,  
			value = "/books/{isbn}"
	)
	public void removeBook(@PathVariable String isbn) {
    	bookService.removeBook(isbn);
    }
	

}
