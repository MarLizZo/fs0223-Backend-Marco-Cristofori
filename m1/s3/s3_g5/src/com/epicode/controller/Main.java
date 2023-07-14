package com.epicode.controller;

import javax.transaction.RollbackException;

import com.epicode.models.Author;
import com.epicode.models.Utente;

public class Main {

	public static void main(String[] args) {
		try {
			
			Author a1 = new Author("James Corey");
			Utente u1 = new Utente("Marco", "LizZo", 190l);
			PersonsDAO.saveAuthor(a1);
			PersonsDAO.saveUser(u1);
			
		} catch (IllegalStateException ex) {
			System.out.println(">> ERRORE Illegal State Exception: " + ex.getMessage());
		} catch (RollbackException ex) {
			System.out.println(">> ERRORE Rollback Exception " + ex.getMessage());
		}
	}
}





















