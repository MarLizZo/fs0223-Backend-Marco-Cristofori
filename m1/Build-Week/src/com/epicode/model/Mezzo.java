package com.epicode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.epicode.enumerators.TipoMezzo;

@Entity
public class Mezzo {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipo_mezzo", nullable=false)
	private TipoMezzo tipoMezzo;
	
	@Column (name="anno_immatricolazione")
	private int annoImmatricolazione;

	private int capienza;
	
	@Column(nullable=false)
	private String marca;
	
	@Column (name="in_servizio")
	private boolean inServizio;
	
	@OneToMany(mappedBy="mezzo")
	private List<Manutenzione> periodiManutenzione;
	
	@ManyToMany(mappedBy="mezziTratta")
	private List<Tratta> tratte;
	
	public Mezzo () {}

	public Mezzo(TipoMezzo tipoMezzo, int annoImmatricolazione, String marca, List<Tratta> listaTratte) {
		super();
		this.tipoMezzo = tipoMezzo;
		this.tratte = listaTratte;
		
		if (tipoMezzo == TipoMezzo.AUTOBUS) {
			this.capienza = 50;
		} else {
			this.capienza = 100;
		}
		
		this.annoImmatricolazione = annoImmatricolazione;
		this.marca = marca;
		this.inServizio = true;
	}

	public long getId() {
		return id;
	}

	public TipoMezzo getTipoMezzo() {
		return tipoMezzo;
	}

	public void setTipoMezzo(TipoMezzo tipoMezzo) {
		this.tipoMezzo = tipoMezzo;
	}

	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public boolean isInServizio() {
		return inServizio;
	}

	public void setInServizio(boolean inServizio) {
		this.inServizio = inServizio;
	}

	public List<Manutenzione> getPeriodiManutenzione() {
		return periodiManutenzione;
	}

	public void setPeriodiManutenzione(List<Manutenzione> periodiManutenzione) {
		this.periodiManutenzione = periodiManutenzione;
	}

	public List<Tratta> getTratte() {
		return tratte;
	}

	public void setTratte(List<Tratta> tratte) {
		this.tratte = tratte;
	}

	@Override
	public String toString() {
		return "Mezzo [id=" + id + ", tipoMezzo=" + tipoMezzo + ", annoImmatricolazione=" + annoImmatricolazione
				+ ", capienza=" + capienza + ", marca=" + marca + ", inServizio=" + inServizio + "]";
	}
	
}
