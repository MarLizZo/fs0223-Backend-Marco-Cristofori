package com.epicode.ex_1;

import java.util.Scanner;

public class Exercise_1 {
	
	private static boolean stringaPariDispari(String str) {
		String[] arr = str.split("");
		if (arr.length % 2 == 0)
			return true;
		else 
			return false;
	}
	
	private static boolean isBisestile(int year) {
		if (year % 4 == 0) {
			return true;
		} else if (year % 100 == 0 && year % 400 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserire una parola: ");
		String input = sc.nextLine();
		
		if (stringaPariDispari(input)) {
			System.out.println("La parola inserire contiene un numero pari di caratteri!");
		} else {
			System.out.println("La parola inserire contiene un numero dispari di caratteri!");
		}
		
		System.out.println("*******************");
		
		System.out.print("Inserire un anno: ");
		String year = sc.nextLine();
		sc.close();
		
		if (isBisestile(Integer.parseInt(year))) {
			System.out.print("L'anno inserito è bisestile!");
		} else {
			System.out.print("L'anno inserito NON è bisestile!");
		}
	}
}























