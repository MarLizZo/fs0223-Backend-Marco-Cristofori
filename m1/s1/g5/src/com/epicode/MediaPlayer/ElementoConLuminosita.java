package com.epicode.MediaPlayer;
import com.epicode.Interfaces.ILuminosita;

public abstract class ElementoConLuminosita extends ElementoMultimediale implements ILuminosita {
	
	protected int livelloLuminosita;

	public ElementoConLuminosita(String _titolo, int _luminosita) {
		super(_titolo);
		this.livelloLuminosita = _luminosita;
	}

	@Override
	public void aumentaLuminosita(int value) {
		if (this.livelloLuminosita + value >= 10) {
			this.livelloLuminosita = 10;
		} else {
			this.livelloLuminosita += value;
		}
	}

	@Override
	public void diminuisciLuminosita(int value) {
		if (this.livelloLuminosita - value <= 0) {
			this.livelloLuminosita = 0;
		} else {
			this.livelloLuminosita -= value;
		}
	}
}
