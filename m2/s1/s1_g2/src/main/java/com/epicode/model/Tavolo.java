package com.epicode.model;

import com.epicode.enumerators.StatoTavolo;

public class Tavolo {
	private int numeroTavolo;
	private StatoTavolo statoTavolo;
	public static int numeroCopertiMassimo = 30;
	
	public Tavolo(int numeroTavolo, StatoTavolo statoTavolo) {
		this.numeroTavolo = numeroTavolo;
		this.statoTavolo = statoTavolo;
	}

	public int getNumeroTavolo() {
		return numeroTavolo;
	}

	public void setNumeroTavolo(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}

	public StatoTavolo getStatoTavolo() {
		return statoTavolo;
	}

	public void setStatoTavolo(StatoTavolo statoTavolo) {
		this.statoTavolo = statoTavolo;
	}

	@Override
	public String toString() {
		return "Tavolo [numeroTavolo=" + numeroTavolo + ", statoTavolo=" + statoTavolo + "]";
	}
}














