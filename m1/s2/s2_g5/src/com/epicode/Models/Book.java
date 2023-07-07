package com.epicode.Models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.epicode.Enums.Genre;

public class Book extends Readable {
	private Author author;
	private List<Genre> generes;

	public Book(String iSBN, String title, LocalDate publishedDate, Integer pages, Author author, List<Genre> genres) {
		super(iSBN, title, publishedDate, pages);
		this.author = author;
		this.generes = genres;
	}

	public Author getAuthor() {
		return author;
	}

	public List<Genre> getGeneres() {
		return generes;
	}
	
	public static Set<Readable> getAllBooks() {
		Set<Readable> lsbook = new HashSet<Readable>();
		lsbook = getAllReadables().stream().filter(el -> el instanceof Book).collect(Collectors.toSet());
		return lsbook;
	}

	@Override
	public String toString() {
		return "Book [author=" + author.getName() + ", generes=" + generes.toString() + ", ISBN=" + getISBN() + ", Title="
				+ getTitle() + ", PublishedDate=" + getPublishedDate() + ", Pages=" + getPages() + "]";
	}
}
