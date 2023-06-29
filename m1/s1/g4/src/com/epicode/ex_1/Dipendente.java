package com.epicode.ex_1;

public class Dipendente {
	protected static double stipendioBase = 1000.00;
	private int matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Dipartimento dipartimento;
	
	public Dipendente(int _matricola) {
		this.matricola = _matricola;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
	}
	
	public Dipendente(int _matricola, double _stipendio, double _importoOrarioStraordinario, Livello _livello, Dipartimento _dipartimento) {
		this.matricola = _matricola;
		this.stipendio = _stipendio;
		this.importoOrarioStraordinario = _importoOrarioStraordinario;
		this.livello = _livello;
		this.dipartimento = _dipartimento;
	}

	public int getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}
	
	public void setImportoOrarioStraordinario(double value) {
		this.importoOrarioStraordinario = value;
	}

	public Livello getLivello() {
		return livello;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento value) {
		this.dipartimento = value;
	}
	
	public void stampaDatiDipendente() {
		System.out.println("Matricola: " + this.matricola);
		System.out.println("Stipendio: " + this.stipendio);
		System.out.println("Importo orario straordinario: " + this.importoOrarioStraordinario);
		System.out.println("Livello: " + this.livello);
		System.out.println("Dipartimento: " + this.dipartimento);
	}
	
	public void promuovi() {
		switch (this.livello) {
			case OPERAIO: {
				this.livello = Livello.IMPIEGATO;
				this.stipendio *= 1.2;
				break;
			}
			case IMPIEGATO: {
				this.livello = Livello.QUADRO;
				this.stipendio *= 1.5;
				break;
			}
			case QUADRO: {
				this.livello = Livello.DIRIGENTE;
				this.stipendio *= 2;
				break;
			}
			case DIRIGENTE: {
				System.out.println("Max level reached!");
				break;
			}
			default: {
				System.out.println("Il dipendente non ha ancora una posizione.");
				break;
			}
		}
	}
	
	public static double calcolaPaga(Dipendente dip) {
		return dip.stipendio;
	}
	
	public static double calcolaPaga(Dipendente dip, int oreExtra) {
		return dip.stipendio + (dip.importoOrarioStraordinario * oreExtra);
	}
}





























