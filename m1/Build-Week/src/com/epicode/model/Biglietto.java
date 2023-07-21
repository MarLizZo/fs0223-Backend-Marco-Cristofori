package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="biglietti")
public class Biglietto extends TitoloDiViaggio {
	
	@Column(nullable=false)
	private boolean vidimato;
	
	@OneToOne
	private Utente utente;
	
	public Biglietto () {}

	public Biglietto(String codice, LocalDate dataDiEmissione, Biglietteria biglietteria, Tratta tratta, Utente utente) {
		super(codice, dataDiEmissione, biglietteria, tratta);
		this.vidimato = false;
		this.utente = utente;
	}

	public boolean isVidimato() {
		return vidimato;
	}

	public void setVidimato(boolean vidimato) {
		this.vidimato = vidimato;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "Biglietto [vidimato=" + vidimato + ", utente=" + utente + ", id=" + id + ", codice=" + codice
				+ ", dataDiEmissione=" + dataDiEmissione + ", tratta=" + tratta
				+ "]";
	}
	
	

	

}
