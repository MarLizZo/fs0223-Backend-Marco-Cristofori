package com.epicode.WeeklyProject;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.epicode.WeeklyProjcect.Enums.Genre;
import com.epicode.WeeklyProjcect.Enums.Periodicita;
import com.epicode.WeeklyProject.Models.Author;
import com.epicode.WeeklyProject.Models.Book;
import com.epicode.WeeklyProject.Models.Magazine;
import com.epicode.WeeklyProject.Models.Readable;

public class Main {

	public static void main(String[] args) {
		
		try {
			//Functions.saveArchive(createElements());
			Functions.readArchive();
		} catch (IOException e) {
			//log.info("Errore nella scrittura del file! " + e.getMessage());
			System.out.println("ERRORE: " + e.getMessage());
		}
		Readable.getAllReadables().stream().forEach(el -> System.out.println(el));
		
		System.out.println();
		
		Optional<Readable> opt = Readable.searchByISBN("ISBN-133");
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			System.out.println("No Readable found with the selected ISBN");
		} 

		
		//Readable.getReadablesByDate(2020).forEach(el -> System.out.println(el));
		
		//Readable.searchByAuthor(a_1).forEach(el -> System.out.println(el));
		
		//Readable.removeElement("ISBN-133");
		//Readable.removeElement("ISBN-144");
		//Readable.removeElement("ISBN-155");
		//Readable.removeElement("ISBN-111");
	}
	
	public static List<Readable> createElements() {
		Author a_1 = new Author(1, "LizZo");
		Author a_2 = new Author(2, "Umberto");
		Author a_3 = new Author(3, "Emanuele");
		
		System.out.println(a_1.toString());
		System.out.println(a_2.toString());
		System.out.println(a_3.toString());

		System.out.println();
		
		List<Genre> g_1 = new ArrayList<Genre>();
		g_1.add(Genre.SCIENCE_FICTION); g_1.add(Genre.SUSPENCE);

		List<Genre> g_2 = new ArrayList<Genre>();
		g_2.add(Genre.DOCUMENTARY); g_2.add(Genre.SCIENCE_FICTION);

		List<Genre> g_3 = new ArrayList<Genre>();
		g_3.add(Genre.DRAMATIC); g_3.add(Genre.SUSPENCE); g_3.add(Genre.FANTASY);
		
		Book b1 = new Book("ISBN-111", "The Expanse 1", LocalDate.of(2018, 9, 21), 576, a_1, g_1);
		Book b2 = new Book("ISBN-122", "The Expanse 2", LocalDate.of(2019, 4, 5), 576, a_2, g_2);
		Book b3 = new Book("ISBN-133", "The Expanse 3", LocalDate.of(2020, 1, 6), 576, a_1, g_1);
		
		Magazine m1 = new Magazine("ISBN-144", "Alla scoperta di Java", LocalDate.of(2020, 11, 1), 123, Periodicita.MENSILE);
		Magazine m2 = new Magazine("ISBN-155", "Unfold the universe", LocalDate.of(2022, 4, 8), 161, Periodicita.SEMESTRALE);
		Magazine m3 = new Magazine("ISBN-166", "AI Updates", LocalDate.of(2023, 2, 3), 123, Periodicita.SETTIMANALE);
		
		List<Readable> list = new ArrayList<Readable>();
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(m1);
		list.add(m2);
		list.add(m3);
		return list;
	}
}



























