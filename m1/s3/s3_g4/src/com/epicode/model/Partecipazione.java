package com.epicode.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.epicode.enumerations.Conferma;

@Entity
@Table(name = "partecipation")
public class Partecipazione {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Persona persona;
	
	@ManyToOne
	private Evento evento;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private Conferma stato;
	
	public Partecipazione() {}

	public Partecipazione(Persona persona, Evento evento, Conferma stato) {
		super();
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public Partecipazione(Long id, Persona persona, Evento evento, Conferma stato) {
		super();
		this.id = id;
		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Conferma getStato() {
		return stato;
	}

	public void setStato(Conferma stato) {
		this.stato = stato;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento=" + evento + ", stato=" + stato + "]";
	}
}
























