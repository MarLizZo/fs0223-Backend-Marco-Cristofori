package com.epicode.ex_3;

import java.util.Scanner;

public class Exercise_3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("Inserisci l'input magico per uscire dal ciclo infinito: ");
			String input = sc.nextLine();
			if (input.equals(":q")) {
				System.out.println("Complimenti, ciclo infinito spezzato!");
				sc.close();
				break;
			} else {
				String[] splitted = input.split("");
				for (int i = 0; i < splitted.length; i++) {
					System.out.print(splitted[i] + ", ");
				}
				System.out.println("");
				System.out.println("Riprova, sarai più fortunato.");
			}
		}
	}
}























