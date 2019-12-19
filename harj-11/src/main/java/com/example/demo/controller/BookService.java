package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.BookRepository;
import com.example.demo.repository.PublisherRepository;

@Component
public class BookService {

	@Autowired
	private BookRepository repo;
	@Autowired
	private PublisherRepository pubrepo;

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
		Optional<Publisher> publisherFound = pubrepo.findById(book.getPublisher().getId());
		// Uusi tallennetaan vain, jos kustantaja on olemassa
		if (publisherFound.isPresent()) {
			repo.save(book);
		}
	}

	public void updateBook(String isbn, Book book) {
		Optional<Publisher> publisherFound = pubrepo.findById(book.getPublisher().getId());
		// Muutos vain, jos kustantaja on olemassa
		if (publisherFound.isPresent()) {
			repo.save(book);
		}
	}

	public void removeBook(String isbn) {
		Optional<Book> found = repo.findById(isbn);
		if (found.isPresent()) {
			repo.deleteById(isbn);
		}
	}

}
