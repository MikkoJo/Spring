package com.example.demo.controller;

import java.util.HashSet;
import java.util.Set;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/*
 *  If you must expose your entity to the outside world, I recommend adding @JsonIgnore on the property that is causing the circular reference. This will tell Jackson not to serialize that property.
 *  Another way is to use the bidirectional features provided by Jackson. 
 *  You can either use @JsonManagedReference or @JsonBackReference. @JsonManagedReference is the "forward" part of the property and it will get serialized normally. 
 *  @JsonBackReference is the "back" part of the reference; it will not be serialized, but will be reconstructed when the "forward" type is deserialized.
 */

/* 
{"name":"Core Java Volume I--Fundamentals",
"edition":11,
"authors":"Cay S. Horstmann",
"pages":928,
"publisher":"Prentice Hall",
"publicationDate":"August 27, 2018",
"isbn":"978-0135166307"}
 */

@Entity
public class Book {
	
	@Id
	private String isbn;
	
	private String name;
	private Integer edition;
	// Yksisuuntainen viittaus tekijöihin

	// Kirja on omistava puoli
	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "book_author",
//		joinColumns = @JoinColumn(name = "book_isbn", referencedColumnName = "id"),
//		inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "isbn")
//	)
	private Set<Author> authors;

	private Integer pages;
	private String publicationDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn
	@JsonBackReference
	//@JsonManagedReference
	private Publisher publisher;

	public Book(String isbn, String name, Integer edition, Set<Author> authors, Integer pages, String publicationDate,
			Publisher publisher) {
		super();
		this.isbn = isbn;
		this.name = name;
		this.edition = edition;
		this.authors = authors;
		this.pages = pages;
		this.publicationDate = publicationDate;
		this.publisher = publisher;
	}

	public Book() {
	}


	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEdition() {
		return edition;
	}

	public void setEdition(Integer edition) {
		this.edition = edition;
	}


	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public String getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [" + (isbn != null ? "isbn=" + isbn + ", " : "") + (name != null ? "name=" + name + ", " : "")
				+ (edition != null ? "edition=" + edition + ", " : "")
				+ (authors != null ? "authors=" + authors + ", " : "") + (pages != null ? "pages=" + pages + ", " : "")
				+ (publicationDate != null ? "publicationDate=" + publicationDate + ", " : "")
				+ (publisher != null ? "publisher=" + publisher : "") + "]";
	}
	
	 
	

}

