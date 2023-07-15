package com.epicode.controller;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.RollbackException;

import com.epicode.enumerations.Genre;
import com.epicode.models.Author;
import com.epicode.models.Book;
import com.epicode.models.ElementoBiblioteca;
import com.epicode.models.Utente;

public class Main {

	public static void main(String[] args) {
		
		try {
			
			//ElementoDAO.getElementsbyStringPart("Exp").forEach(el -> System.out.println(el));
			//ElementoDAO.getElementsbyAuthor(PersonsDAO.getAuthor(1)).forEach(el -> System.out.println(el));
			//ElementoDAO.removeElementByISBN("ISBN-10999");
			
			/*Author a1 = new Author("James Corey");
			Author a2 = new Author("Umbertone Nazionale");
			Author a3 = new Author("Anonimo speciale");
			Utente u1 = new Utente("Marco", "LizZo", 190l);
			
			PersonsDAO.saveAuthor(a1);
			PersonsDAO.saveAuthor(a2);
			PersonsDAO.saveAuthor(a3);
			PersonsDAO.saveUser(u1); 
			
			Author a1 = PersonsDAO.getAuthor(1);
			Author a2 = PersonsDAO.getAuthor(2);
			Author a3 = PersonsDAO.getAuthor(3);
			
			Book b_1 = new Book("ISBN-89009", "The Expanse 1", a1, LocalDate.of(2015, 6, 2), 576, Genre.SCIENCE_FICTION);
			Book b_2 = new Book("ISBN-91432", "The Expanse 2", a1, LocalDate.of(2016, 7, 11), 537, Genre.SCIENCE_FICTION);
			Book b_3 = new Book("ISBN-31519", "Java for beginners", a2, LocalDate.of(2020, 2, 5), 537, Genre.DRAMATIC);
			Book b_4 = new Book("ISBN-10999", "Come si fa cosa?", PersonsDAO.getAuthor(3), LocalDate.of(2017, 10, 10), 537, Genre.THRILLER);
			
			ElementoDAO.saveElement(b_1);
			ElementoDAO.saveElement(b_2);
			ElementoDAO.saveElement(b_3);
			ElementoDAO.saveElement(b_4);*/
			
		} /*catch (IllegalStateException ex) {
			System.out.println(">> ERRORE Illegal State Exception: " + ex.getMessage());
		} catch (RollbackException ex) {
			System.out.println(">> ERRORE Rollback Exception " + ex.getMessage());
		}*/ 
		catch (Exception ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		}
	}
}





















