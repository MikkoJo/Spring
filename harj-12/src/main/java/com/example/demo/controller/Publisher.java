package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;


@Entity
public class Publisher {
	
	@Id
	private Integer id;
	
	private String name;
	
	// Ei-omistava puoli, joten viittaus mappedBy-attribuutilla	
	//@OneToMany(mappedBy = "publisher", cascade=CascadeType.PERSIST)
	@OneToMany(mappedBy = "publisher", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonManagedReference
	//@JsonBackReference
	//@JsonIgnore - ei toimi pelkästään
	private Set<Book> books;
	
	public Publisher() {
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

