package com.epicode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="rivenditori_autorizzati")
public class RivenditoreAutorizzato extends Biglietteria {
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String proprietario;
	
	public RivenditoreAutorizzato() {}

	public RivenditoreAutorizzato(String nome, String proprietario) {
		super();
		this.nome = nome;
		this.proprietario = proprietario;
	}
	
	public RivenditoreAutorizzato(String citta, String nome, String proprietario) {
		super(citta);
		this.nome = nome;
		this.proprietario = proprietario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	@Override
	public String toString() {
		return "RivenditoreAutorizzato [nome=" + nome + ", proprietario=" + proprietario + ", citta=" + citta + "]";
	}
}
