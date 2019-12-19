package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.controller.Book;
import com.example.demo.controller.Author;

// Perus CRUD - Luokka, toinen avain Id-kenttä
public interface AuthorRepository extends CrudRepository<Author,Integer>{
	
}