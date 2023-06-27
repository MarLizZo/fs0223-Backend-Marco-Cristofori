package com.epicode.ex_1;

public class Exercise_1 {

	public static void main(String[] args) {
		System.out.println("Primo rettangolo inizializzato: ");
		Rettangolo rett_1 = new Rettangolo(11.21, 32.65);
		Rettangolo.stampaRettangolo(rett_1);

		System.out.println("*********************************");
		System.out.println("Secondo rettangolo inizializzato: ");
		Rettangolo rett_2 = new Rettangolo(5.1, 10.2);
		Rettangolo.stampaRettangolo(rett_2);

		System.out.println("*********************************");
		System.out.println("Inizio metodo stampaDueRettangoli: ");
		Rettangolo.stampaDueRettangoli(rett_1, rett_2);
	}

}
