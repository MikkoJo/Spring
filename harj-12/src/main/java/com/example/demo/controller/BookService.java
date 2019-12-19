package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository repo;
	@Autowired
	private PublisherRepository pubrepo;
	@Autowired
	private AuthorRepository authrepo;


	public List<Book> getBooks() {
		List<Book> books = new ArrayList<>();
		Iterable<Book> bookIter = repo.findAll();
		bookIter.forEach(books::add);
		return books;
	}

	public Book getBook(String code) {
		return repo.findById(code).get();
	}

	public void addBook(Book book) {
		// Toimii ainakin tämän kanssa
//		for (Author author: book.getAuthors()) {
//			Set<Book> bookSet = new HashSet<>();
//			bookSet.add(book);				
//			author.setBooks(bookSet);
//		}
		repo.save(book);
		
	}

	/*  
	 * Tallentaan myös kustantajan sekä tekijät,
	 * jos niitä ei ole jo aiemmin tallennettu
	 * 
	 * TODO: Tehty kokeilumielessä - pelkkä save() toimii, jos kaikki konfiguraatiot 
	 * ja erityisesti relaatiomääritykset entiteettien välillä on JPA:ssa täysin oikein
	 */
	public void addBookAll(Book book) {
		Optional<Publisher> publisherFound = pubrepo.findById(book.getPublisher().getId());
		if (publisherFound.isEmpty()) {
			pubrepo.save(book.getPublisher());
		}
		for (Author author: book.getAuthors()) {
			Optional<Author> authorFound = authrepo.findById(author.getId());
			if (authorFound.isEmpty()) {
				Set<Book> bookSet = new HashSet<>();
				bookSet.add(book);				
				author.setBooks(bookSet);
				authrepo.save(author);
			}
			else {
				Set<Book> bookSet = new HashSet<>();
				bookSet.add(book);				
				author.setBooks(bookSet);
				//author.setName("");
			}
		}
		repo.save(book);
	}
	
	
	public void updateBook(String isbn, Book book) {
		if (isAuthorsAndPublishersFound(book)) {
			repo.save(book);
		}
	}
	
	/* 
	 * Tarkastaa ennen tallennusta, että tekijät ja kustantajat on olemassa
	 * 
	 * @return true, jos tekijät ja kustantaja oli olemassa, muuten false
	 */
	private boolean isAuthorsAndPublishersFound(Book book) {
		Optional<Publisher> publisherFound = pubrepo.findById(book.getPublisher().getId());
		boolean authorsFound = true;
		for (Author author : book.getAuthors()) {
			Optional<Author> authorFound = authrepo.findById(author.getId());
			if (authorFound.isEmpty()) {
				authorsFound = false;
				break;
			}
		}
		// Uusi tallennetaan vain, jos kustantaja ja tekijät on olemassa
		return publisherFound.isPresent() || authorsFound;
	}

	public void removeBook(String isbn) {
		Optional<Book> found = repo.findById(isbn);
		if (found.isPresent()) {
			repo.deleteById(isbn);
		}
	}

}
