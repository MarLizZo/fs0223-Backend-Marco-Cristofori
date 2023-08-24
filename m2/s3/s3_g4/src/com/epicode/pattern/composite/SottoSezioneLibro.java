package com.epicode.pattern.composite;

public class SottoSezioneLibro implements BloccoPagine {
	
	private String name;
	private int numeroPagine;
	
	public SottoSezioneLibro(String name, int numeroPagine) {
		this.name = name;
		this.numeroPagine = numeroPagine;
	}

	@Override
	public String getNomeBlocco() {
		return this.name;
	}

	@Override
	public int getNumeroPagine() {
		return this.numeroPagine;
	}

}
