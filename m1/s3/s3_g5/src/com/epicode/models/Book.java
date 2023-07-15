package com.epicode.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.epicode.enumerations.Genre;

@Entity
@NamedQuery(name = "Book.getAll", query = "SELECT b FROM Book b")
public class Book extends ElementoBiblioteca {
	
	@ManyToOne
	private Author autore;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Genre genre;

	public Book() {
		super();
	}

	public Book(Long id, String iSBN, String title, LocalDate publishedDate, Integer pages, Genre genre) {
		super(id, iSBN, title, publishedDate, pages);
		this.genre = genre;
	}

	public Book(String iSBN, String title, Author author, LocalDate publishedDate, Integer pages, Genre genre) {
		super(iSBN, title, publishedDate, pages);
		this.autore = author;
		this.genre = genre;
	}

	public Author getAutore() {
		return autore;
	}

	public void setAutore(Author autore) {
		this.autore = autore;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [autore=" + autore + ", genre=" + genre + ", toString()=" + super.toString() + "]";
	}

}






















