package com.epicode.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.epicode.enumerations.TipoEvento;

@Entity
public class GaraDiAtletica extends Evento {
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Persona> setAtleti;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Persona vincitore;
	
	public GaraDiAtletica() {}
	
	public GaraDiAtletica(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location, Set<Persona> setAtleti, Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.setAtleti = setAtleti;
		this.vincitore = vincitore;
	}

	public Set<Persona> getSetAtleti() {
		return setAtleti;
	}

	public void setSetAtleti(Set<Persona> setAtleti) {
		this.setAtleti = setAtleti;
	}

	public Persona getVincitore() {
		return vincitore;
	}

	public void setVincitore(Persona vincitore) {
		this.vincitore = vincitore;
	}

	@Override
	public String toString() {
		return "GaraDiAtletica [setAtleti=" + setAtleti + ", vincitore=" + vincitore + ", "
				+ super.toString() + "]";
	}
}




















