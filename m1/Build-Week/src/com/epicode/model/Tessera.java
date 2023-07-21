package com.epicode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tessere")
public class Tessera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne (mappedBy="tessera")
	private Utente utente;
	
	@Column(nullable=false, unique=true)
	private String codiceUtente;
	
	
	public Tessera() {
		super();
	}


	public Tessera(Utente utente, String codiceUtente) {
		super();
		this.utente = utente;
		this.codiceUtente = codiceUtente;
	}


	public Long getId() {
		return id;
	}


	public Utente getUtente() {
		return utente;
	}


	public void setUtente(Utente utente) {
		this.utente = utente;
	}


	public String getCodiceUtente() {
		return codiceUtente;
	}


	public void setCodiceUtente(String codiceUtente) {
		this.codiceUtente = codiceUtente;
	}


	@Override
	public String toString() {
		return "Tessera [id=" + id + ", codiceUtente=" + codiceUtente + "]";
	}

	
	
}
