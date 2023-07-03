package com.epicode.ex_2;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise_2 {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Exercise_2.class);
		System.out.println("Benvenuto!");
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println();
			System.out.println("Vuoi sapere quanti Km per litro hai percorso?");
			
			try {
				System.out.print("Inserisci il numero di Kilometri che hai percorso: ");
				String kmInput = sc.nextLine();
				double kmInputValue = Double.parseDouble(kmInput);
				
				if (kmInputValue == 0) {
					System.out.println("Va bene. Arrivederci alla prossima!");
					break;
				} else {
					System.out.print("Bene! Ora dimmi quanti litri hai consumato: ");
					String ltInput = sc.nextLine();
					double ltInputValue = Double.parseDouble(ltInput);
					
					if (ltInputValue == 0) {
						throw new ArithmeticException("Non è possibile calcolare il rapporto per 0..");
					} else {
						System.out.println("Hai percorso " + kmInputValue / ltInputValue + " Kilometri per Litro!");
					}
				}
				
			} catch (NumberFormatException ex) {
				log.debug("Input non valido, inserire numero Kilometri!");
			} catch (ArithmeticException ex) {
				log.debug(ex.getMessage());
			} catch (Exception ex) {
				log.debug("Qualcosa non quadra, riprova!");
			}
		}
	}
}
