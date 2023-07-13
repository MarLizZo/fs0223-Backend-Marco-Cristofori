package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.epicode.enumerations.Genere;
import com.epicode.enumerations.TipoEvento;

@Entity
public class Concerto extends Evento {
	
	@Column(nullable = false)
	private Genere genere;
	
	@Column(nullable = false)
	private boolean inStreaming;
	
	public Concerto() {
		super();
	}
	
	public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location, Genere genere, boolean inStreaming) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.genere = genere;
		this.inStreaming = inStreaming;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public boolean isInStreaming() {
		return inStreaming;
	}

	public void setInStreaming(boolean inStreaming) {
		this.inStreaming = inStreaming;
	}

	@Override
	public String toString() {
		return "Concerto [genere=" + genere + ", inStreaming=" + inStreaming + ", " + super.toString() + "]";
	}
}






















