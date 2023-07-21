package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.epicode.enumerators.Periodicita;

@Entity
@Table(name="abbonamenti")
public class Abbonamento extends TitoloDiViaggio {
	
	@Column(name="data_scadenza", nullable=false)
	private LocalDate dataScadenza;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Periodicita periodicita;
	
	@ManyToOne
	private Tessera tessera;
	
	public Abbonamento () {}

	public Abbonamento(String codice, LocalDate dataDiEmissione, Biglietteria biglietteria, Tratta tratta,
			 Periodicita periodicita, Tessera tessera) {
		super(codice, dataDiEmissione, biglietteria, tratta);
		
		if (periodicita == Periodicita.SETTIMANALE) {
			this.dataScadenza = dataDiEmissione.plusDays(7);
		} else {
			this.dataScadenza = dataDiEmissione.plusDays(30);
		}
		
		this.periodicita = periodicita;
		this.tessera = tessera;
	}

	public LocalDate getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(LocalDate dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	@Override
	public String toString() {
		return "Abbonamento [dataScadenza=" + dataScadenza + ", periodicita=" + periodicita + ", tessera=" + tessera
				+ ", id=" + id + ", codice=" + codice + ", dataDiEmissione=" + dataDiEmissione + ", tratta=" + tratta + "]";
	}
	
	
}
