package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
	
	@Autowired
	private AuthorService AuthorService;
	
    @RequestMapping("/authors") 
	public List<Author> getAuthors() {
    	return AuthorService.getAuthors();
    }

    @RequestMapping("/authors/{id}") 
	public Author getAuthor(@PathVariable Integer id) {
    	return AuthorService.getAuthor(id);
    }
    

    // Lisätään taulukko tekijöitä yhdellä
    @RequestMapping(
			method = RequestMethod.POST,  
			value = "/authors/all"
	)
	public void addAuthor(@RequestBody List<Author> authors) {
    	for (Author author: authors) {
    		AuthorService.addAuthor(author);
    	}
    }
    	

}
