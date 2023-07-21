package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "titoli_di_viaggio")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "titoloDiViaggio.getAll", query = "SELECT el FROM TitoloDiViaggio el")
public class TitoloDiViaggio {
	
	@Id
	@SequenceGenerator(name = "titolo_seq", sequenceName = "titolo_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "titolo_seq")
	protected long id;
	
	@Column(nullable=false, unique=true)
	protected String codice;
	
	@Column(name="data_di_emissione",nullable=false)
	protected LocalDate dataDiEmissione;
	
	@ManyToOne
	protected Biglietteria biglietteria;
	
	@ManyToOne
	protected Tratta tratta;
	
	
	public TitoloDiViaggio() {}

	public TitoloDiViaggio(String codice, LocalDate dataDiEmissione, Biglietteria biglietteria, Tratta tratta) {
		super();
		this.codice = codice;
		this.dataDiEmissione = dataDiEmissione;
		this.biglietteria = biglietteria;
		this.tratta = tratta;
	}

	public long getId() {
		return id;
	}


	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public LocalDate getDataDiEmissione() {
		return dataDiEmissione;
	}

	public void setDataDiEmissione(LocalDate dataDiEmissione) {
		this.dataDiEmissione = dataDiEmissione;
	}

	public Biglietteria getBiglietteria() {
		return biglietteria;
	}

	public void setBiglietteria(Biglietteria biglietteria) {
		this.biglietteria = biglietteria;
	}

	public Tratta getTratta() {
		return tratta;
	}

	public void setTratta(Tratta tratta) {
		this.tratta = tratta;
	}

	@Override
	public String toString() {
		return "TitoloDiViaggio [id=" + id + ", codice=" + codice + ", dataDiEmissione=" + dataDiEmissione
				+ ", biglietteria=" + biglietteria + ", tratta=" + tratta + "]";
	}
	
}
