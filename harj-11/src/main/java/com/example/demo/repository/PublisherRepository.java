package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.controller.Book;
import com.example.demo.controller.Publisher;

// Perus CRUD - Luokka, toinen avain Id-kenttä
public interface PublisherRepository extends CrudRepository<Publisher,Integer>{
	
}