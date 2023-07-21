package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class BigliettiConvalidati {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	private Mezzo mezzo;
	
	@OneToOne
	private Biglietto biglietto;
	
	private LocalDate data;
	
	public BigliettiConvalidati () {}

	public BigliettiConvalidati(Mezzo mezzo, Biglietto biglietto, LocalDate data) {
		super();
		this.mezzo = mezzo;
		this.biglietto = biglietto;
		this.data = data;
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

	public Biglietto getBiglietto() {
		return biglietto;
	}

	public void setBiglietto(Biglietto biglietto) {
		this.biglietto = biglietto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "BigliettiConvalidati [id=" + id + ", mezzo=" + mezzo + ", biglietto=" + biglietto + ", data=" + data
				+ "]";
	}
	

}
