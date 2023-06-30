package com.epicode.MediaPlayer;
import com.epicode.Interfaces.IVolume;

public abstract class ElementoConVolume extends ElementoMultimediale implements IVolume {
	
	protected int livelloVolume;

	public ElementoConVolume(String _titolo, int _volume) {
		super(_titolo);
		this.livelloVolume = _volume;
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
