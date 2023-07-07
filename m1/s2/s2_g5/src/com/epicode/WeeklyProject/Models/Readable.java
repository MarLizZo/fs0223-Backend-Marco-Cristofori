package com.epicode.WeeklyProject.Models;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.epicode.WeeklyProject.Functions;

public abstract class Readable {
	private String ISBN;
	private String title;
	private LocalDate publishedDate;
	private Integer pages;
	protected static List<Readable> readableList = new ArrayList<Readable>();
	
	public Readable(String iSBN, String title, LocalDate publishedDate, Integer pages) {
		this.ISBN = iSBN;
		this.title = title;
		this.publishedDate = publishedDate;
		this.pages = pages;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getTitle() {
		return title;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public Integer getPages() {
		return pages;
	}
	
	public static List<Readable> getAllReadables() {
		return readableList;
	}
	
	public static List<Readable> getReadablesByDate(int year) {
		return readableList.stream().filter(el -> el.getPublishedDate().getYear() == year).collect(Collectors.toList());
	}
	
	public static void addElement(Readable element) {
		readableList.add(element);
	}
	
	public static boolean removeElement(String isbn) {
		return readableList.removeIf(el -> el.getISBN().equals(isbn));
	}
	
	public static Optional<Readable> searchByISBN(String isbn) {
		return readableList.stream().filter(el -> el.getISBN().equals(isbn)).findFirst();
	}
	
	public static List<Book> searchByAuthor(Author aut) {
		List<Book> ls = new ArrayList<Book>();
		readableList.forEach(el -> {
			if (el instanceof Book) {
				ls.add((Book) el);
			}
		});
		return ls.stream().filter(el -> el.getAuthor().equals(aut)).collect(Collectors.toList());
	}
	
	public static void setList(List<Readable> ls) throws IOException {
		readableList = ls;
	}

	@Override
	public String toString() {
		return "Readable [ISBN=" + ISBN + ", title=" + title + ", publishedDate=" + publishedDate + ", pages=" + pages
				+ "]";
	}
}























