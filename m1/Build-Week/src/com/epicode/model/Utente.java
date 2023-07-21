package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.epicode.enumerators.Genere;

@Entity
@Table(name="utenti")
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String cognome;
	
	@Column(nullable=false)
	private LocalDate dataNascita;
	
	@Column(nullable=false)
	private String citta;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Genere genere;
	
	@OneToOne
	private Tessera tessera;
	
	public Utente() {
		super();
	}

	public Utente(String nome, String cognome, LocalDate dataNascita, String citta,  Genere genere,
			Tessera tessera) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.citta = citta;
		this.genere = genere;
		this.tessera = tessera;
	}
	
	public Utente(String nome, String cognome, LocalDate dataNascita, String citta, Genere genere) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.citta = citta;
		this.genere = genere;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public Tessera getTesseraUtente() {
		return tessera;
	}

	public void setTesseraUtente(Tessera tessera) {
		this.tessera = tessera;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", dataNascita=" + dataNascita
				+ ", citta=" + citta + ", genere=" + genere + ", tesseraUtente=" + tessera + "]";
	}
	
	
}
