package com.epicode.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import com.epicode.enumerators.StatoOrdine;

public class Ordine {
	private long numeroOrdine;
	private StatoOrdine statoOrdine;
	private List<IProdotto> listaProdotti;
	private LocalDate dataAcquisizione;
	private int numeroCoperti;
	private double totaleOrdine;
	private Tavolo tavolo;
	
	public Ordine(long numeroOrdine, StatoOrdine statoOrdine, List<IProdotto> listaProdotti, LocalDate dataAcquisizione,
			int numeroCoperti, Tavolo tavolo) {
		super();
		this.numeroOrdine = numeroOrdine;
		this.statoOrdine = statoOrdine;
		this.listaProdotti = listaProdotti;
		this.dataAcquisizione = dataAcquisizione;
		this.numeroCoperti = numeroCoperti;
		this.totaleOrdine = getTotaleOrdineC();
		this.tavolo = tavolo;
	}

	public double getTotaleOrdineC() {
		double tot = 0;
		for (Object el : listaProdotti) {
	        if (el instanceof Pizza) {
	            Pizza p = (Pizza) el;
	            tot += p.getPrezzo();
	        } else {
	        	Bevanda b = (Bevanda) el;
	        	tot += b.getPrezzo();
	        }
	    }
		return tot;
	}

	public long getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(long numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public StatoOrdine getStatoOrdine() {
		return statoOrdine;
	}

	public void setStatoOrdine(StatoOrdine statoOrdine) {
		this.statoOrdine = statoOrdine;
	}

	public List<IProdotto> getListaProdotti() {
		return listaProdotti;
	}

	public void setListaProdotti(List<IProdotto> listaProdotti) {
		this.listaProdotti = listaProdotti;
	}

	public LocalDate getDataAcquisizione() {
		return dataAcquisizione;
	}

	public void setDataAcquisizione(LocalDate dataAcquisizione) {
		this.dataAcquisizione = dataAcquisizione;
	}

	public int getNumeroCoperti() {
		return numeroCoperti;
	}

	public void setNumeroCoperti(int numeroCoperti) {
		this.numeroCoperti = numeroCoperti;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}

	public void setTotaleOrdine(double totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}
	
	public double getTotaleOrdine() {
		return BigDecimal.valueOf(totaleOrdine).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
	}

	@Override
	public String toString() {
		return "Ordine [numeroOrdine=" + numeroOrdine + ", statoOrdine=" + statoOrdine + ", listaProdotti="
				+ listaProdotti + ", dataAcquisizione=" + dataAcquisizione + ", numeroCoperti=" + numeroCoperti
				+ ", totaleOrdine=" + getTotaleOrdine() + ", tavolo=" + tavolo + "]";
	}
}


















