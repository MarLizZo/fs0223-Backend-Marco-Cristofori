package com.epicode.ex_2;

public class SIM {
	private String number;
	private double credit = 0.00;
	private String[] calls = new String[5];
	
	public SIM(String _number, double _credit) {
		this.number = _number;
		this.credit = _credit;
	}
	
	public void showDetails() {
		System.out.println("Numero: " + this.number);
		System.out.println("Credito: " + this.credit + " Euro");
		System.out.println("Lista chiamate: ");
		for (int i = 0; i < calls.length; i++) {
			System.out.println(calls[i]);
		}
	}
}


















