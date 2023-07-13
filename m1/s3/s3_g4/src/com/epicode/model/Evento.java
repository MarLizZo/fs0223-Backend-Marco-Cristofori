package com.epicode.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.epicode.enumerations.TipoEvento;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Evento {
	@Id
	@SequenceGenerator(name = "evento_seq", sequenceName = "evento_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evento_seq")
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String titolo;
	
	@Column(name = "event_date", nullable = false)
	private LocalDate dataEvento;
	
	@Column(name = "description")
	private String descrizione;
	
	@Column(name = "event_type", nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoEvento tipoEvento;
	
	@Column(name = "max_partecipants", nullable = false)
	private Integer numeroMassimoPartecipanti;
	
	@ManyToOne
	private Location location;
	
	@OneToMany(mappedBy = "evento", cascade = CascadeType.REMOVE)
	private Set<Partecipazione> partecipazione;
	
	public Evento(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location) {
		super();
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
	}

	public Evento(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location, Set<Partecipazione> partecipazione) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
		this.location = location;
		this.partecipazione = partecipazione;
	}

	public Evento() {
		super();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(LocalDate dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public Integer getNumeroMassimoPartecipanti() {
		return numeroMassimoPartecipanti;
	}

	public void setNumeroMassimoPartecipanti(Integer numeroMassimoPartecipanti) {
		this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Set<Partecipazione> getPartecipazione() {
		return partecipazione;
	}

	public void setPartecipazione(Set<Partecipazione> partecipazione) {
		this.partecipazione = partecipazione;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento=" + dataEvento + ", descrizione=" + descrizione
				+ ", tipoEvento=" + tipoEvento + ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti
				+ ", location=" + location + "]";
	}
}




























