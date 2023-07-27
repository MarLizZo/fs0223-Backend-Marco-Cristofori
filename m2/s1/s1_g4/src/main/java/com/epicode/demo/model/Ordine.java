package com.epicode.demo.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import com.epicode.demo.enumerators.StatoOrdine;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ordine {
	private Integer id;
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

	@Override
	public String toString() {
		return "Ordine [numeroOrdine=" + numeroOrdine + ", statoOrdine=" + statoOrdine + ", listaProdotti="
				+ listaProdotti + ", dataAcquisizione=" + dataAcquisizione + ", numeroCoperti=" + numeroCoperti
				+ ", totaleOrdine=" + BigDecimal.valueOf(getTotaleOrdine()).setScale(3, RoundingMode.HALF_EVEN).doubleValue() + ", tavolo=" + tavolo + "]";
	}
}


















