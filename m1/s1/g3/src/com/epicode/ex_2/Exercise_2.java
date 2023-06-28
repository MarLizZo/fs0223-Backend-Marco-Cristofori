package com.epicode.ex_2;

import java.util.Scanner;

public class Exercise_2 {
	
	private static void logNumber(int num) {
		switch (num) {
			case 0: {
				System.out.println("Zero");
				break;
			}
			case 1: {
				System.out.println("Uno");
				break;
			}
			case 2: {
				System.out.println("Due");
				break;
			}
			case 3: {
				System.out.println("Tre");
				break;
			}
			default: {
				System.out.println("Il numero non rispetta le condizioni.");
				break;
			}
		}
	}

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un numero: ");
		String num = sc.nextLine();
		sc.close();
		logNumber(Integer.parseInt(num));
	}
}

















