package com.epicode.pattern.composite;

import java.util.List;

public class SezioneLibro implements BloccoPagine {
	
	private String name;
	private int numeroPagine;
	private List<SottoSezioneLibro> sottoSezioni;
	
	public SezioneLibro(String name, int numeroPagine, List<SottoSezioneLibro> sottoSezioni) {
		this.name = name;
		if (sottoSezioni.size() == 0) {
			this.numeroPagine = numeroPagine;
		} else {
			sottoSezioni.stream().forEach(s -> this.numeroPagine += s.getNumeroPagine());
		}
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
