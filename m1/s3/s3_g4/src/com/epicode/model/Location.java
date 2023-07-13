package com.epicode.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String nome;
	
	@Column(name = "city", nullable = false)
	private String citta;
	
	@OneToMany(mappedBy = "location")
	Set<Evento> listaEvento;
	
	public Location() {}
	
	public Location(String nome, String citta) {
		super();
		this.nome = nome;
		this.citta = citta;
	}
	public Location(Long id, String nome, String citta) {
		super();
		this.id = id;
		this.nome = nome;
		this.citta = citta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", nome=" + nome + ", citta=" + citta + "]";
	}
}
























