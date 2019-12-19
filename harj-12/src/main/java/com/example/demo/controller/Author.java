package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;


/*
 * Kirjan tekijä entiteetti
 */

@Entity
public class Author {
	
	@Id
	private Integer id;
	
	private String name;
	
	// Tekijällä voi olla monta kirjaa
	// Ei-omistava puoli, joten viittaus mappedBy-attribuutilla	
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = { CascadeType.PERSIST, CascadeType.MERGE },
            mappedBy = "authors")
	@JsonIgnore // Ei tulostu mukaan JSON-dataan
	private Set<Book> books;	
	
	public Author() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

}

