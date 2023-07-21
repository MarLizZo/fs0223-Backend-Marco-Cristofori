package com.epicode.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="distributori_automatici")
public class DistributoreAutomatico extends Biglietteria {
	
	@Column(nullable=false)
	private String codice;
	
	@Column(nullable=false)
	private boolean inFunzione;
	
	public DistributoreAutomatico() {}
	
	public DistributoreAutomatico(String codice, boolean inFunzione) {
		super();
		this.codice = codice;
		this.inFunzione = inFunzione;
	}
	
	public DistributoreAutomatico(String citta, String codice, boolean inFunzione) {
		super(citta);
		this.codice = codice;
		this.inFunzione = inFunzione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public boolean isInFunzione() {
		return inFunzione;
	}

	public void setInFunzione(boolean inFunzione) {
		this.inFunzione = inFunzione;
	}

	@Override
	public String toString() {
		return "DistributoreAutomatico [codice=" + codice + ", inFunzione=" + inFunzione + ", citta=" + citta + "]";
	}
}
