package com.epicode.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "ElementoBiblioteca.getAll", query = "SELECT el FROM ElementoBiblioteca el")
public class ElementoBiblioteca {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String ISBN;
	private String title;
	private LocalDate publishedDate;
	private Integer pages;
	
	public ElementoBiblioteca() {
		super();
	}

	public ElementoBiblioteca(Long id, String iSBN, String title, LocalDate publishedDate, Integer pages) {
		super();
		this.id = id;
		this.ISBN = iSBN;
		this.title = title;
		this.publishedDate = publishedDate;
		this.pages = pages;
	}

	public ElementoBiblioteca(String iSBN, String title, LocalDate publishedDate, Integer pages) {
		super();
		this.ISBN = iSBN;
		this.title = title;
		this.publishedDate = publishedDate;
		this.pages = pages;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		this.ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "ElementoBiblioteca [id=" + id + ", ISBN=" + ISBN + ", title=" + title + ", publishedDate="
				+ publishedDate + ", pages=" + pages + "]";
	}
}






















