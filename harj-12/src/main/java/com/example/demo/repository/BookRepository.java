package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.controller.Book;
import com.example.demo.controller.Publisher;

// Laajentaa olemassa olevaa CRUD-toteutusta omilla metodeilla
// Perus CRUD on rajapinnassa valmiiksi toteutettu
public interface BookRepository extends CrudRepository<Book,String>{
	
	// Hakee Publisher-luokan Id-ominaisuudesta
	public List<Book> findByPublisherId(String publisherId);
	// Hakee Publisher-luokan Name-ominaisuudesta
	public List<Book> findByPublisherName(String publisherName);
	
}