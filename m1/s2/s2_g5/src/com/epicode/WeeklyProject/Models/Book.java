package com.epicode.WeeklyProject.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.epicode.WeeklyProjcect.Enums.Genre;

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
	
	public static List<Book> getAllBooks() {
		List<Book> lsbook = new ArrayList<Book>();
		lsbook = (List<Book>) getAllReadables().stream().filter(el -> el instanceof Book);
		return lsbook;
	}

	@Override
	public String toString() {
		return "Book [author=" + author.getName() + ", generes=" + generes.toString() + ", ISBN=" + getISBN() + ", Title="
				+ getTitle() + ", PublishedDate=" + getPublishedDate() + ", Pages=" + getPages() + "]";
	}
}
























