package com.epicode.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import com.epicode.enumerations.TipoEvento;

@Entity
public class PartitaDiCalcio extends Evento {
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincente;
	private Integer golSquadraDiCasa = 0;
	private Integer golSquadraOspite = 0;
	
	public PartitaDiCalcio() {}
	
	public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento,
			Integer numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite,
			String squadraVincente, Integer golSquadraDiCasa, Integer golSquadraOspite) {
		super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincente = squadraVincente;
		this.golSquadraDiCasa = golSquadraDiCasa;
		this.golSquadraOspite = golSquadraOspite;
	}

	public String getSquadraDiCasa() {
		return squadraDiCasa;
	}

	public void setSquadraDiCasa(String squadraDiCasa) {
		this.squadraDiCasa = squadraDiCasa;
	}

	public String getSquadraOspite() {
		return squadraOspite;
	}

	public void setSquadraOspite(String squadraOspite) {
		this.squadraOspite = squadraOspite;
	}

	public String getSquadraVincente() {
		return squadraVincente;
	}

	public void setSquadraVincente(String squadraVincente) {
		this.squadraVincente = squadraVincente;
	}

	public Integer getGolSquadraDiCasa() {
		return golSquadraDiCasa;
	}

	public void setGolSquadraDiCasa(Integer golSquadraDiCasa) {
		this.golSquadraDiCasa = golSquadraDiCasa;
	}

	public Integer getGolSquadraOspite() {
		return golSquadraOspite;
	}

	public void setGolSquadraOspite(Integer golSquadraOspite) {
		this.golSquadraOspite = golSquadraOspite;
	}

	@Override
	public String toString() {
		return "PartitaDiCalcio [squadraDiCasa=" + squadraDiCasa + ", squadraOspite=" + squadraOspite
				+ ", squadraVincente=" + squadraVincente + ", golSquadraDiCasa=" + golSquadraDiCasa
				+ ", golSquadraOspite=" + golSquadraOspite + ", " + super.toString() + "]";
	}
}



















