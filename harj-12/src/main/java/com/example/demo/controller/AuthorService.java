package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.repository.AuthorRepository;


@Component
public class AuthorService {

	@Autowired
	private AuthorRepository repo;

	public List<Author> getAuthors() {
		List<Author> authors = new ArrayList<>();
		Iterable<Author> authorIter = repo.findAll();
		authorIter.forEach(authors::add);
		return authors;
	}

	public Author getAuthor(Integer id) {
		return repo.findById(id).get();
	}

	public void addAuthor(Author author) {
		repo.save(author);
	}


}
