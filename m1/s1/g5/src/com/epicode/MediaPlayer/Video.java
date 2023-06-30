package com.epicode.MediaPlayer;
import com.epicode.Interfaces.IRiproducibile;

public class Video extends ElementoConVolumeAndLuminosita implements IRiproducibile {
	
	private int durata;

	public Video(String _titolo, int _durata, int _volume, int _luminosita) {
		super(_titolo, _volume, _luminosita);
		this.durata = _durata;
	}

	@Override
	public void play() {
		String escl = "";
		String ast = "";
		
		for (int i = 0; i < this.livelloVolume; i++) {
			escl += "!";
		}
		
		for (int i = 0; i < this.livelloLuminosita; i++) {
			ast += "*";
		}
		
		for (int i = 0; i < this.durata; i++) {
			System.out.println("Il tuo video: " + this.getTitolo() + escl + ast);
		}
	}
}



























