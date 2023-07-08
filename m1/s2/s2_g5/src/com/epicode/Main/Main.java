package com.epicode.Main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
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
		Scanner sc = new Scanner(System.in);
		System.out.println("Benvenuto Umberto!");
		System.out.println();
		
		//Primo step - init lista
		do {
			try {
				Functions.initializeList();
			} catch (NumberFormatException ex) {
				System.out.println();
				System.out.println("** Per favore non barare, inserisci una delle opzioni disponibili **");
				System.out.println();
			} catch (ExitException ex) {
				break;
			}
		} while (!Functions.initialized);
		
		
		// Secondo step - scelta operazione
		if (Functions.initialized) {
			System.out.println();
			System.out.println("Molto bene! La lista di libri e riviste è pronta e aspetta di essere smaciullata :)");
			System.out.println();
			
			while (!Functions.exitFlag) {
				try {
					Functions.chooseOperation();
				} catch (NumberFormatException ex) {
					System.out.println();
					System.out.println("Non farmi arrabbiareee. Seleziona una delle opzioni disponibili");
					System.out.println();
				}
			}
		}
		
		
		/*
		Readable.getReadablesByDate(2020).forEach(el -> System.out.println(el));

		//Readable.searchByAuthor(a_1).forEach(el -> System.out.println(el));
		
		//Readable.removeElement("ISBN-133");
		//Readable.removeElement("ISBN-144");
		//Readable.removeElement("ISBN-155");
		//Readable.removeElement("ISBN-111"); */
	}
}

























