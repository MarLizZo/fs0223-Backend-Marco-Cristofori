package com.epicode.MediaPlayer;

public class Main {

	public static void main(String[] args) {
		Immagine img_1 = new Immagine("Cat Meme", 7);
		img_1.show();
		
		
		RegistrazioneAudio reg_1 = new RegistrazioneAudio("My podcast", 5, 3);
		reg_1.play();
		
		Video vid_1 = new Video("Funny Cat", 4, 2, 6);
		vid_1.play();
	}
}
