package com.epicode.demo.model;

import com.epicode.demo.enumerators.StatoTavolo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Tavolo {
	private int numeroTavolo;
	private StatoTavolo statoTavolo;
	public static int numeroCopertiMassimo = 30;
	
	public Tavolo(int numeroTavolo, StatoTavolo statoTavolo) {
		this.numeroTavolo = numeroTavolo;
		this.statoTavolo = statoTavolo;
	}

	@Override
	public String toString() {
		return "Tavolo [numeroTavolo=" + numeroTavolo + ", statoTavolo=" + statoTavolo + "]";
	}
}














