package com.epicode.ex_2;

public class SIM {
	private String number;
	private double credit = 0.00;
	private Call[] calls = new Call[5];
	
	public SIM(String _number) {
		this.number = _number;
	}
	
	public void showDetails() {
		System.out.println("Numero: " + this.number);
		System.out.println("Credito: " + this.credit + " Euro");
		System.out.println("Lista chiamate: ");
		for (int i = 0; i < calls.length; i++) {
			if (calls[i] != null) {
				System.out.println("Chiamata a: " + calls[i].numberToCall + " di minuti: " + calls[i].duration);
			}
		}
	}
	
	public void recharge(double _credit) {
		this.credit += _credit;
	}
	
	public void doCall(double _duration, String _numberToCall) {
		if (this.credit < 1) {
			System.out.println("Credito insufficiente! Tirchio ricarica!");
		} else {
			for (int i = 0; i < calls.length; i++) {
				if (calls[i] == null) {
					Call c = new Call(_duration, _numberToCall);
					calls[i] = c;
					break;
				}
			}
		}
	}
}


















