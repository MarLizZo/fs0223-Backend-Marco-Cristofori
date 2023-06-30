package com.epicode.MediaPlayer;
import com.epicode.Interfaces.*;

public abstract class ElementoConVolumeAndLuminosita extends ElementoMultimediale implements IVolume, ILuminosita {
	
	protected int livelloVolume;
	protected int livelloLuminosita;

	public ElementoConVolumeAndLuminosita(String _titolo, int _volume, int _luminosita) {
		super(_titolo);
		this.livelloLuminosita = _luminosita;
		this.livelloVolume = _volume;
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

	@Override
	public void alzaVolume(int value) {
		if (this.livelloVolume + value >= 10) {
			this.livelloVolume = 10;
		} else {
			this.livelloVolume += value;
		}
	}

	@Override
	public void abbassaVolume(int value) {
		if (this.livelloVolume - value <= 0) {
			this.livelloVolume = 0;
		} else {
			this.livelloVolume -= value;
		}
	}
}
