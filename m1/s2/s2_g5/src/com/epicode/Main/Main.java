package com.epicode.Main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.Enums.Genre;
import com.epicode.Enums.Periodicita;
import com.epicode.Models.*;
import com.epicode.Models.Readable;

public class Main {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Main.class);
		
		try {
			Functions.saveArchive(createElements());
			Functions.readArchive();
		} catch (IOException e) {
			log.error("Errore nella scrittura del file! " + e.getMessage());
		}
		
		Readable.getAllReadables().stream().forEach(el -> System.out.println(el));
		
		System.out.println();
		
		Optional<Readable> opt = Readable.searchByISBN("ISBN-133");
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			log.info("No Readable found with the selected ISBN");
		} 

		System.out.println();
		
		Readable.getReadablesByDate(2020).forEach(el -> System.out.println(el));

		//Readable.searchByAuthor(a_1).forEach(el -> System.out.println(el));
		
		//Readable.removeElement("ISBN-133");
		//Readable.removeElement("ISBN-144");
		//Readable.removeElement("ISBN-155");
		//Readable.removeElement("ISBN-111");
	}
	
	public static Set<Readable> createElements() {
		Author a_1 = new Author(1, "LizZo");
		Author a_2 = new Author(2, "Umberto");
		Author a_3 = new Author(3, "Emanuele");
		
		List<Genre> g_1 = new ArrayList<Genre>();
		g_1.add(Genre.SCIENCE_FICTION); g_1.add(Genre.SUSPENCE);

		List<Genre> g_2 = new ArrayList<Genre>();
		g_2.add(Genre.DOCUMENTARY); g_2.add(Genre.SCIENCE_FICTION);

		List<Genre> g_3 = new ArrayList<Genre>();
		g_3.add(Genre.DRAMATIC); g_3.add(Genre.SUSPENCE); g_3.add(Genre.FANTASY);
		
		Book b1 = new Book("ISBN-111", "The Expanse 1", LocalDate.of(2018, 9, 21), 576, a_1, g_1);
		Book b2 = new Book("ISBN-122", "The Expanse 2", LocalDate.of(2019, 4, 5), 522, a_2, g_2);
		Book b3 = new Book("ISBN-133", "The Expanse 3", LocalDate.of(2020, 1, 6), 498, a_1, g_1);
		Book b4 = new Book("ISBN-144", "The Expanse 4", LocalDate.of(2021, 1, 1), 519, a_3, g_3);
		
		Magazine m1 = new Magazine("ISBN-155", "Alla scoperta di Java", LocalDate.of(2020, 11, 1), 123, Periodicita.MENSILE);
		Magazine m2 = new Magazine("ISBN-166", "Unfold the universe", LocalDate.of(2022, 4, 8), 161, Periodicita.SEMESTRALE);
		Magazine m3 = new Magazine("ISBN-177", "AI Updates", LocalDate.of(2023, 2, 3), 87, Periodicita.SETTIMANALE);
		
		Set<Readable> list = new HashSet<Readable>();
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		list.add(b4);
		list.add(m1);
		list.add(m2);
		list.add(m3);
		return list;
	}
}
