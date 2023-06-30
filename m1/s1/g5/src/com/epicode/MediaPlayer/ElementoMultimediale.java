package com.epicode.MediaPlayer;

public abstract class ElementoMultimediale {
	protected String titolo;
	
	public ElementoMultimediale(String _titolo) {
		this.titolo = _titolo;
	}

	public String getTitolo() {
		return this.titolo;
	}
}
