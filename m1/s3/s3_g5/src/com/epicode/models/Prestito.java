package com.epicode.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Prestito.getAll", query = "SELECT p FROM Prestito p")
public class Prestito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Utente user;
	
	@OneToOne(fetch = FetchType.EAGER)
	private ElementoBiblioteca elementoPrestato;
	
	@Column(nullable = false)
	private LocalDate dataInizioPrestito;
	
	private LocalDate dataRestituzionePrevista;
	
	private LocalDate restituzioneEffettiva;
	
	public Prestito() {}

	public Prestito(Long id, Utente user, ElementoBiblioteca elementoPrestato, LocalDate dataInizioPrestito,
			LocalDate dataRestituzionePrevista, LocalDate restituzioneEffettiva) {
		super();
		this.id = id;
		this.user = user;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataRestituzionePrevista;
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	public Prestito(Utente user, ElementoBiblioteca elementoPrestato, LocalDate dataInizioPrestito, LocalDate restituzioneEffettiva) {
		super();
		this.user = user;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	public Prestito(Utente user, ElementoBiblioteca elementoPrestato, LocalDate dataInizioPrestito) {
		super();
		this.user = user;
		this.elementoPrestato = elementoPrestato;
		this.dataInizioPrestito = dataInizioPrestito;
		this.dataRestituzionePrevista = this.dataInizioPrestito.plusDays(30);
	}

	public Utente getUser() {
		return user;
	}

	public void setUser(Utente user) {
		this.user = user;
	}

	public ElementoBiblioteca getElementoPrestato() {
		return elementoPrestato;
	}

	public void setElementoPrestato(ElementoBiblioteca elementoPrestato) {
		this.elementoPrestato = elementoPrestato;
	}

	public LocalDate getDataInizioPrestito() {
		return dataInizioPrestito;
	}

	public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
		this.dataInizioPrestito = dataInizioPrestito;
	}

	public LocalDate getDataRestituzionePrevista() {
		return dataRestituzionePrevista;
	}

	public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
		this.dataRestituzionePrevista = dataRestituzionePrevista;
	}

	public LocalDate getRestituzioneEffettiva() {
		return restituzioneEffettiva;
	}

	public void setRestituzioneEffettiva(LocalDate restituzioneEffettiva) {
		this.restituzioneEffettiva = restituzioneEffettiva;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Prestito [id=" + id + ", user=" + user + ", elementoPrestato=" + elementoPrestato
				+ ", dataInizioPrestito=" + dataInizioPrestito + ", dataRestituzionePrevista="
				+ dataRestituzionePrevista + ", restituzioneEffettiva=" + restituzioneEffettiva + "]";
	}
}






















