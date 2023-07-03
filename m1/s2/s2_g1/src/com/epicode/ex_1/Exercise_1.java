package com.epicode.ex_1;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise_1 {
	
	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Exercise_1.class);
		int[] arr = new int[] { 5, 39, 11, 45, 99 };
		System.out.println("Benvenuto!");
		
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("L'array attualmente contiene questi valori:");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			System.out.print("Scegli una posizione dell'array da modificare: ");
			
			try {
				String input = sc.nextLine();
				int InputInt = Integer.parseInt(input);
				if (InputInt == 0) {
					System.out.println("Arrivederci alla prossima!");
					break;
				} else {
					System.out.print("Molto bene, scegli un valore da inserire nella posizione " + input + ": ");
					String value = sc.nextLine();
					arr[InputInt - 1] = Integer.parseInt(value);
				}
				
			} catch (NumberFormatException ex) {
				log.debug("Hai inserito un input non valido!");
			} catch (ArrayIndexOutOfBoundsException ex) {
				log.debug("La posizione inserita non è valida.");
			} catch (Exception ex) {
				log.debug("Qualcosa è andato storto, riprova!");
			}
		}
	}
}
