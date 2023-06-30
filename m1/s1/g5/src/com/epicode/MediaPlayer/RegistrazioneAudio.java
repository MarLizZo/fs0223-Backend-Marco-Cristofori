package com.epicode.MediaPlayer;
import com.epicode.Interfaces.IRiproducibile;

public class RegistrazioneAudio extends ElementoConVolume implements IRiproducibile {
		
	private int durata;
	
	public RegistrazioneAudio(String _titolo, int _volume, int _durata) {
		super(_titolo, _volume);
		this.durata = _durata;
	}

	@Override
	public void play() {
		String vol = "";
		
		for (int i = 0; i < this.livelloVolume; i++) {
			vol += "!";
		}
		for (int i = 0; i < durata; i++) {
			System.out.println("La tua registrazione: " + this.getTitolo() + vol);
		}
	}
}
























