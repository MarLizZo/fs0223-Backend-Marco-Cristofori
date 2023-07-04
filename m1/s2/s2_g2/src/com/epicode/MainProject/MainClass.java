package com.epicode.MainProject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainClass {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(MainClass.class);
		Scanner sc = new Scanner(System.in);
		System.out.println("Benvenuto!");
		
		while (true) {
			System.out.print("Inserisci quanti elementi dovrà avere l'array: ");
			String input = sc.nextLine();
			
			try {
				int inputValue = Integer.parseInt(input);
				if (inputValue == 0) {
					System.out.println("Arrivederci!");
					break;
				} else {
					Set<String> s = new HashSet<String>();
					Collection<String> c = new ArrayList<String>();
					
					for (int i = 0; i < inputValue; i++) {
						System.out.print("Cosa devo inserire alla posizione " + (i + 1) + "? ");
						String value = sc.nextLine();
						if (!s.add(value)) {
							c.add(value);
							s.remove(value);
						}
					}
					System.out.println("Molto bene, ecco i risultati.");
					System.out.println();
					
					System.out.println("Elementi duplicati:");
					c.forEach((element) -> System.out.println(element + " "));
					System.out.println();
					
					System.out.println("Numero di parole distinte inserite: " + s.size());
					System.out.println();
					
					System.out.println("Elenco delle parole distinte:");
					s.forEach((element) -> System.out.println(element + " "));

					System.out.println();
					System.out.println("Altro giro! Si ricomincia!");
				}
				
			} catch (NumberFormatException ex) {
				log.error("L'input inserito non è valido!");
			}
		}
	}
}

























