package com.epicode.ex_1;

public class Exercise_1 {

	public static void main(String[] args) {
		Dipendente lizzo = new Dipendente(1, 2000, 35, Livello.QUADRO, Dipartimento.PRODUZIONE);
		Dipendente anonimo = new Dipendente(2);
		
		lizzo.stampaDatiDipendente();
		System.out.println("*********************************");
		anonimo.stampaDatiDipendente();
		
		lizzo.promuovi();
		lizzo.setImportoOrarioStraordinario(40);
		System.out.println(lizzo.getLivello());
		System.out.println(lizzo.getStipendio());
		
		
		System.out.println("*********************************");
		
		anonimo.setDipartimento(Dipartimento.VENDITE);
		anonimo.promuovi();
		System.out.println(anonimo.getDipartimento());
		System.out.println(Dipendente.calcolaPaga(anonimo));
		
		System.out.println("*********************************");
		
		System.out.println(Dipendente.calcolaPaga(lizzo, 11));
		System.out.println(Dipendente.calcolaPaga(anonimo, 3));
	}
}













