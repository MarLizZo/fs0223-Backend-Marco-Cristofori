package com.epicode.MediaPlayer;
import com.epicode.Interfaces.*;

public class Immagine extends ElementoConLuminosita implements ILuminosita, IVisualizzabile {
	
	public Immagine(String _titolo, int _luminosita) {
		super(_titolo, _luminosita);
	}
	
	@Override
	public void show() {
		String ast = "";
		for (int i = 0; i < this.livelloLuminosita; i++) {
			ast += "*";
		}
		System.out.println("La tua immagine: " + this.getTitolo() + ast);
	}
}




















