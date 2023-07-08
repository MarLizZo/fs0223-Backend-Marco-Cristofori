package com.epicode.Main;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.epicode.Enums.Genre;
import com.epicode.Enums.Periodicita;
import com.epicode.Models.*;
import com.epicode.Models.Readable;

public class Functions {
	private static File file = new File("doc/test.txt");
	static Scanner sc = new Scanner(System.in);
	static boolean initialized = false;
	static Logger log = LoggerFactory.getLogger(Functions.class);
	static boolean exitFlag = false;
	
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

	public static void initializeList() throws NumberFormatException, ExitException {
		System.out.println("0 > Esci dal programma");
		System.out.println("1 > Carica da file doc/test.txt");
		System.out.println("2 > Istanzio gli oggetti e creo la lista tramite codice");
		System.out.print("Come preferisci procedere? ->> ");
		
		int input = Integer.parseInt(sc.nextLine());
		
		if (input == 1) {
			try {
				Functions.readArchive();
				initialized = true;
			} catch (IOException ex) {
				log.error("Errore imprevisto nel caricamento del file.. " + ex.getMessage());
			}
		} else if (input == 2) {
			Readable.setList(createElements());
			initialized = true;
		} else if (input == 0) {
			System.out.println("Arrivederci!");
			try {
				Thread.sleep(1000);
				throw new ExitException("Exited!");
			} catch (InterruptedException e) {
				log.error("Mmmh qualcosa di strano sta succedendo.. " + e.getMessage());
			}
		} else {
			System.out.println("** Non mi piace quello che hai scritto, riprova. **");
			System.out.println(); 
		}
	}
	
	public static void chooseOperation() throws NumberFormatException {
		System.out.println("0 > Esci dal programma");
		System.out.println("1 > Visualizza tutti i libri e riviste");
		System.out.println("2 > Cerca un elemento tramite il suo ISBN");
		System.out.println("3 > Rimuovi un elemento dalla lista tramite il suo ISBN");
		System.out.println("4 > Cerca elementi tramite un anno di pubblicazione");
		System.out.println("5 > Cerca elementi tramite il nome dell'autore");
		
		System.out.print("Quale operazione vuoi eseguire? ->> ");
		int input = Integer.parseInt(sc.nextLine());
		
		switch (input) {
			case 0: {
				System.out.println();
				System.out.println("Arrivederci!");
				exitFlag = true;
				break;
			}
			case 1: {
				System.out.println();
				Readable.getAllReadables().stream().forEach(el -> System.out.println(el));
				System.out.println();
				break;
			}
			case 2: {
				System.out.println();
				searchISBN();
				System.out.println();
				break;
			}
			case 3: {
				System.out.println();
				delete();
				System.out.println();
				break;
			}
			case 4: {
				System.out.println();
				try {
					searchYear();
				} catch (NumberFormatException e) {
					log.error("Non farmi arrabbiareeee");
				}
				System.out.println();
				break;
			}
			case 5: {
				System.out.println();
				searchAuthor();
				System.out.println();
				break;
			}
			default: {
				System.out.println();
				System.out.println("Opzione non valida, non farmi arrabbiare");
				System.out.println();
				break;
			}
		}
	}
	
	public static void searchAuthor() {
		System.out.print("Inserisci il nome dell'autore ->> ");
		String input = sc.nextLine();
		System.out.println();
		
		List<Book> ls = Readable.searchByAuthor(input);
		if (ls.size() == 0) {
			System.out.println("** Nessun elemento trovato per l'autore inserito **");
		} else {
			ls.forEach(el -> System.out.println(el.toString()));
		}
	}
	
	public static void searchYear() throws NumberFormatException {
		System.out.print("Inserisci il codice ISBN dell'elemento da stampare ->> ");
		int input = Integer.parseInt(sc.nextLine());
		
		List<Readable> ls = Readable.getReadablesByDate(input);
		System.out.println();
		
		if (ls.size() == 0) {
			System.out.println("** Nessun elemento trovato con l'anno di pubblicazione inserito **");
		} else {
			ls.forEach(el -> System.out.println(el.toString()));
		}
	}
	
	public static void searchISBN() {
		System.out.print("Inserisci il codice ISBN dell'elemento da stampare ->> ");
		String input = sc.nextLine();
		
		Optional<Readable> opt = Readable.searchByISBN(input);
		System.out.println();
		
		if (opt.isPresent()) {
			System.out.println(opt.get());
		} else {
			log.info("** Nessun elemento trovato con il codice ISBN inserito **");
		} 
	}
	
	public static void delete() {
		System.out.print("Inserisci il codice ISBN dell'elemento da eliminare ->> ");
		String input = sc.nextLine();
		System.out.println();
		
		if (Readable.removeByISBN(input)) {
			System.out.println("Elemento eliminato con successo!");
		} else {
			System.out.println("** Nessun elemento trovato con il codice ISBN inserito **");
		}
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
