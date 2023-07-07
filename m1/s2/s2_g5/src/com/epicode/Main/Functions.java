package com.epicode.Main;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.epicode.Enums.Genre;
import com.epicode.Enums.Periodicita;
import com.epicode.Models.*;
import com.epicode.Models.Readable;

public class Functions {
	private static File file = new File("doc/test.txt");
	
	public static void saveArchive(Set<Readable> ls) throws IOException {
		if (file.exists()) file.delete();
		StringBuilder text = new StringBuilder();
		
		ls.forEach(el -> {
			boolean isBook = el instanceof Book ? true : false;
			
			if (isBook) {
				text.append("type=book@");
			} else {
				text.append("type=magazine@");
			}
			
			text.append(el.getISBN() + "@").append(el.getTitle() + "@")
				.append(el.getPublishedDate().toString() + "@").append(el.getPages().toString() + "@");
			if (isBook) {
				Book b = (Book) el;
				text.append(b.getAuthor().getName() + "@").append(b.getAuthor().getId().toString() + "@");
				b.getGeneres().forEach(g -> text.append(g.toString() + "&"));
			} else {
				Magazine m = (Magazine) el;
				text.append(m.getPeriodicita().toString() + "@");
			}
			text.append("#");
		});
		FileUtils.writeStringToFile(file, text.toString(), "UTF-8", true);
	}
	
	public static void readArchive() throws IOException {
		String text = FileUtils.readFileToString(file, "UTF-8");
		String[] splitted = text.split("#");
		
		Set<Readable> lsFinal = new HashSet<Readable>();
		
		for (int i = 0; i < splitted.length; i++) {
			String[] singleReadable = splitted[i].split("@");
			String isbn = singleReadable[1];
			String title = singleReadable[2];
			LocalDate publishedDate = LocalDate.parse(singleReadable[3], DateTimeFormatter.ISO_LOCAL_DATE);
			Integer pages = Integer.parseInt(singleReadable[4]);
			
			if (singleReadable[0].contains("book")) {
				String authorId = singleReadable[5];
				String authorName = singleReadable[6];
				List<Genre> genres = new ArrayList<Genre>();
				String[] genresArr = singleReadable[7].split("&");
				
				for (String s : genresArr) {
					genres.add(Genre.valueOf(s));
				}
				
				lsFinal.add(new Book(isbn, title, publishedDate, pages, new Author(Integer.getInteger(authorId), authorName), genres));
			} else {
				Periodicita period = Periodicita.valueOf(singleReadable[5]);
				lsFinal.add(new Magazine(isbn, title, publishedDate, pages, period));
			}
			Readable.setList(lsFinal);
		}
	}
}