package com.epicode.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.RollbackException;

import com.epicode.enumerations.Genre;
import com.epicode.enumerations.Periodicita;
import com.epicode.models.Author;
import com.epicode.models.Book;
import com.epicode.models.ElementoBiblioteca;
import com.epicode.models.Magazine;
import com.epicode.models.Prestito;
import com.epicode.models.Utente;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			// STEP 1: Salva utenti e autori
			/*
			Utente u1 = new Utente("Marco", "LizZo", 190l);
			Utente u2 = new Utente("Sconosciuto", "Misterioso", 239l);
			Utente u3 = new Utente("Geltrude", "Pazza", 481l);

			Author a1 = new Author("James Corey");
			Author a2 = new Author("Umbertone Nazionale");
			Author a3 = new Author("Anonimo speciale");
			
			PersonsDAO.saveUser(u1);
			PersonsDAO.saveUser(u2);
			PersonsDAO.saveUser(u3);
			PersonsDAO.saveAuthor(a1);
			PersonsDAO.saveAuthor(a2);
			PersonsDAO.saveAuthor(a3);
			*/
			
			
			// STEP 2: Salva libri e riviste
			/*
			Magazine m_1 = new Magazine("ISBN-99890", "AstroNews", LocalDate.of(2022, 6, 2), 152, Periodicita.MENSILE);
			Magazine m_2 = new Magazine("ISBN-94811", "Notizie dell'altro mondo", LocalDate.of(2021, 5, 12), 152, Periodicita.SETTIMANALE);
			
			Book b_1 = new Book("ISBN-89009", "The Expanse 1", PersonsDAO.getAuthor(1), LocalDate.of(2015, 6, 2), 576, Genre.SCIENCE_FICTION);
			Book b_2 = new Book("ISBN-91432", "The Expanse 2", PersonsDAO.getAuthor(1), LocalDate.of(2016, 7, 11), 537, Genre.SCIENCE_FICTION);
			Book b_3 = new Book("ISBN-31519", "Java for beginners", PersonsDAO.getAuthor(2), LocalDate.of(2020, 2, 5), 537, Genre.DRAMATIC);
			Book b_4 = new Book("ISBN-10999", "Come si fa cosa?", PersonsDAO.getAuthor(3), LocalDate.of(2017, 10, 10), 537, Genre.THRILLER);

			ElementoDAO.saveElement(m_1);
			ElementoDAO.saveElement(m_2);
			ElementoDAO.saveElement(b_1);
			ElementoDAO.saveElement(b_2);
			ElementoDAO.saveElement(b_3);
			ElementoDAO.saveElement(b_4);
			*/
			
			
			// STEP 3: Salva i prestiti
			/*
			Prestito p1 = new Prestito(PersonsDAO.getUser(1), ElementoDAO.getElementById(7), LocalDate.now().minusDays(10l));
			Prestito p2 = new Prestito(PersonsDAO.getUser(1), ElementoDAO.getElementById(8), LocalDate.now());
			Prestito p3 = new Prestito(PersonsDAO.getUser(1), ElementoDAO.getElementById(6), LocalDate.of(2023, 06, 11), LocalDate.of(2023, 06, 22));
			Prestito p4 = new Prestito(PersonsDAO.getUser(2), ElementoDAO.getElementById(10), LocalDate.of(2023, 04, 3), LocalDate.of(2023, 04, 26));
			Prestito p5 = new Prestito(PersonsDAO.getUser(3), ElementoDAO.getElementById(11), LocalDate.of(2023, 04, 3));
			Prestito p6 = new Prestito(PersonsDAO.getUser(2), ElementoDAO.getElementById(12), LocalDate.of(2023, 05, 12));
			
			PrestitoDAO.savePrestito(p1);
			PrestitoDAO.savePrestito(p2);
			PrestitoDAO.savePrestito(p3);
			PrestitoDAO.savePrestito(p4);
			PrestitoDAO.savePrestito(p5);
			PrestitoDAO.savePrestito(p6);
			*/
			
			
			//STEP 4: Test dei metodi
			
			/*
			System.out.println(ElementoDAO.getElementByISBN("ISBN-31519"));
			ElementoDAO.getElementsbyAuthor(PersonsDAO.getAuthor(1)).forEach(el -> System.out.println(el));
			ElementoDAO.getElementsByYear(2017);
			ElementoDAO.getElementsbyStringPart("Expan").forEach(el -> System.out.println(el));
			PrestitoDAO.getPrestitiInCorso().forEach(el -> System.out.println(el));
			PrestitoDAO.getPrestitiByCardNumber(190).forEach(el -> System.out.println(el));
			PrestitoDAO.getPrestitiInCorsoByCardNumber(239).forEach(el -> System.out.println(el));
			ElementoDAO.removeElementByISBN("ISBN-10999");
			PrestitoDAO.getPrestitiScadutiNonRestituiti().forEach(el -> System.out.println(el));
			*/
			
			
			
		} /*catch (IllegalStateException ex) {
			System.out.println(">> ERRORE Illegal State Exception: " + ex.getMessage());
		} catch (RollbackException ex) {
			System.out.println(">> ERRORE Rollback Exception " + ex.getMessage());
		}*/ 
		catch (Exception ex) {
			System.out.println("** ERRORE: " + ex.getMessage());
		}
	}
}





















