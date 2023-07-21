package com.epicode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "biglietterie")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "biglietteria.getAll", query = "SELECT b FROM Biglietteria b")
public class Biglietteria {
	
	@Id
	@SequenceGenerator(name = "biglietteria_seq", sequenceName = "biglietteria_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "biglietteria_seq")
	protected long id;
	
	@Column(nullable=false)
	protected String citta;
	
	@OneToMany(mappedBy="biglietteria", fetch = FetchType.EAGER)
	protected List<TitoloDiViaggio> titoliVenduti;
	
	public Biglietteria() {}

	public Biglietteria(String citta) {
		super();
		this.citta = citta;
	}

	public long getId() {
		return id;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public List<TitoloDiViaggio> getTitoliVenduti() {
		return titoliVenduti;
	}

	public void setTitoliVenduti(List<TitoloDiViaggio> titoliVenduti) {
		this.titoliVenduti = titoliVenduti;
	}

	@Override
	public String toString() {
		return "Biglietteria [id=" + id + ", citta=" + citta + "]";
	}
	
	
	
	

}
