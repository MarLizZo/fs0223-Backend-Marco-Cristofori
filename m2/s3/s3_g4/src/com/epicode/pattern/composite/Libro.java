package com.epicode.pattern.composite;

import java.util.List;

public class Libro implements BloccoPagine {
	
	private String name;
	private double price;
	private List<SezioneLibro> sezioni;
	
	public Libro(String name, double price, List<SezioneLibro> sezioni) {
		this.name = name;
		this.price = price;
		this.sezioni = sezioni;
	}

	@Override
	public String getNomeBlocco() {
		return this.name;
	}

	@Override
	public int getNumeroPagine() {
		int num = 0;
		for (SezioneLibro s : sezioni) {
			num += s.getNumeroPagine();
		}
		return num;
	}
}



























