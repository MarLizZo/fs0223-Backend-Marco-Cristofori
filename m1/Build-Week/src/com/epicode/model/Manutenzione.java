package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Manutenzione {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
    @ManyToOne
	private Mezzo mezzo;
    
    @Column(name="data_inizio", nullable=false)
    private LocalDate dataInizio;
    
    @Column(name="data_fine")
    private LocalDate dataFine;
    
    public Manutenzione () {}

	public Manutenzione(Mezzo mezzo, LocalDate dataInizio, LocalDate dataFine) {
		super();
		this.mezzo = mezzo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public long getId() {
		return id;
	}

	public Mezzo getMezzo() {
		return mezzo;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDate getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDate dataFine) {
		this.dataFine = dataFine;
	}

	@Override
	public String toString() {
		return "Manutenzione [id=" + id + ", mezzo=" + mezzo.getId() + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine
				+ "]";
	}
	
	
    
}
