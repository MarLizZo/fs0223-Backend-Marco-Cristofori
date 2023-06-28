package com.epicode.ex_4;

import java.util.Scanner;

public class Exercise_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Inserisci un numero e partirà il countdown: ");
		String input = sc.nextLine();
		sc.close();
		int num = Integer.parseInt(input);
		for (int i = num; i >= 0; i--) {
			if (i == 0) {
				System.out.println(i + " -- Bye bye");
				break;
			}
			System.out.println(i);
			try        
			{
			    Thread.sleep(1000);
			} 
			catch (InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
		}
	}
}
