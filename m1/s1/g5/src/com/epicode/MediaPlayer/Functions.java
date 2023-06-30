package com.epicode.MediaPlayer;
import java.util.Scanner;

public class Functions {
	private static Scanner sc = new Scanner(System.in);
	public static ElementoMultimediale[] medias = new ElementoMultimediale[5];
	private static int luminosita = 0;
	private static int volume = 0;
	private static int durata = 0;
	private static boolean exit = false;
	
	public static int chooseFrom(int position) {
		int result = 0;
		do {
			System.out.println("1 ==> Inserisci una immagine");
			System.out.println("2 ==> Inserisci una registrazione audio");
			System.out.println("3 ==> Inserisci un video");
			System.out.println();
			
			switch (position) {
				case 0: {
					System.out.print("Cosa vuoi inserire in prima posizione? ");
					break;
				}
				case 1: {
					System.out.print("Cosa vuoi inserire in seconda posizione? ");
					break;
				}
				case 2: {
					System.out.print("Cosa vuoi inserire in terza posizione? ");
					break;
				}
				case 3: {
					System.out.print("Cosa vuoi inserire in quarta posizione? ");
					break;
				}
				case 4: {
					System.out.print("Cosa vuoi inserire in quinta posizione? ");
					break;
				}
				default: {
					System.out.println("Mmmmmh qualcosa non quadra.. ");
				}
			}
			
				String res = sc.nextLine();
				try {
					if (Integer.parseInt(res) > 3 || Integer.parseInt(res) == 0)  {
						System.out.println();
						System.out.println("******************************************************************");
						System.out.println(">>>> Input non corretto.. Seleziona uno dei possibili valori! <<<<");
						System.out.println("******************************************************************");
						System.out.println();
					} else {
						result = Integer.parseInt(res);
					}
				} catch (NumberFormatException ex) {
					System.out.println();
					System.out.println("******************************************************************");
					System.out.println(">>>> Input non corretto.. Seleziona uno dei possibili valori! <<<<");
					System.out.println("******************************************************************");
					System.out.println();
				}
			} while (result == 0 || result > 3);
		
		return result;
	}

	public static String chooseTitle() {
		System.out.print("Bene, ora scrivimi il titolo: ");
		return sc.nextLine();
	}
	
	public static void chooseDurata() {
		System.out.print("Imposta la durata in minuti: ");
		try {
			int res = Integer.parseInt(sc.nextLine());
			if (res > 0 && res <= 10)
				durata = res;
			else {
				System.out.println("*****************");
				System.out.println(">> INPUT ERRATO - Solo numeri da 1 a 10! <<");
				System.out.println("*****************");
			}
				
		} catch (NumberFormatException ex) {
			System.out.println("*****************");
			System.out.println(">> INPUT ERRATO - Inserire un numero! <<");
			System.out.println("*****************");
		}
	}
	
	public static void chooseVolume() {
		System.out.print("Imposta un livello di volume da 1 a 10: ");
		try {
			int res = Integer.parseInt(sc.nextLine());
			if (res > 0 && res <= 10)
				volume = res;
			else {
				System.out.println("*****************");
				System.out.println(">> INPUT ERRATO - Solo numeri da 1 a 10! <<");
				System.out.println("*****************");
			}
				
		} catch (NumberFormatException ex) {
			System.out.println("*****************");
			System.out.println(">> INPUT ERRATO - Inserire un numero! <<");
			System.out.println("*****************");
		}
	}
	
	public static void chooseLuminosita() {
		System.out.print("Imposta un livello di luminosita da 1 a 10: ");
		try {
			int res = Integer.parseInt(sc.nextLine());
			if (res > 0 && res <= 10)
				luminosita = res;
			else {
				System.out.println("*****************");
				System.out.println(">> INPUT ERRATO - Solo numeri da 1 a 10! <<");
				System.out.println("*****************");
			}
				
		} catch (NumberFormatException ex) {
			System.out.println("************");
			System.out.println(">> INPUT ERRATO - Inserire un numero! <<");
			System.out.println("************");
		}
	}

	public static void createObject(int type, int position) {
		String title = chooseTitle();
		switch (type) {
			case 1: {
				luminosita = 0;
				
				while (luminosita == 0 || luminosita > 10) {
					chooseLuminosita();
				}
				
				medias[position] = new Immagine(title, luminosita);
				System.out.println();
				System.out.println("****************************");
				System.out.println("Immagine > " + title + " < creata con successo!");
				System.out.println("****************************");
				System.out.println();
				break;
			}
			case 2: {
				volume = 0;
				durata = 0;
				
				while (volume == 0 || volume > 10) {
					chooseVolume();
				}
				
				while (durata == 0 || durata > 10) {
					chooseDurata();
				}
				
				medias[position] = new RegistrazioneAudio(title, volume, durata);
				System.out.println();
				System.out.println("****************************");
				System.out.println("Registrazione > " + title + " < creata con successo!");
				System.out.println("****************************");
				System.out.println();
				break;
			}
			case 3: {
				luminosita = 0;
				volume = 0;
				durata = 0;
				
				while (luminosita == 0 || luminosita > 10) {
					chooseLuminosita();
				}
				
				while (volume == 0 || volume > 10) {
					chooseVolume();
				}
				
				while (durata == 0 || durata > 10) {
					chooseDurata();
				}
				
				medias[position] = new Video(title, durata, volume, luminosita);
				System.out.println();
				System.out.println("****************************");
				System.out.println("Video > " + title + " < creato con successo!");
				System.out.println("****************************");
				System.out.println();
				break;
			}
		}
	}

	public static void logObjects() {
		do {
			System.out.println("0 ==> Esci dal programma");
			System.out.println("1 ==> Stampa elemento numero 1");
			System.out.println("2 ==> Stampa elemento numero 2");
			System.out.println("3 ==> Stampa elemento numero 3");
			System.out.println("4 ==> Stampa elemento numero 4");
			System.out.println("5 ==> Stampa elemento numero 5");
			System.out.print(">> Seleziona un'opzione: ");
			
			try {
				int res = Integer.parseInt(sc.nextLine());
				if (res == 0) {
					System.out.println();
					System.out.println("*****************************");
					System.out.println("Arrivederci e grazie Umberto!");
					System.out.println("*****************************");
					exit = true;
				}
				res -= 1;
				if (res >= 0 && res <= 4) {
					if (medias[res] instanceof Immagine) {
						Immagine img = (Immagine) medias[res];
						System.out.println();
						img.show();
						System.out.println();
					} else if (medias[res] instanceof RegistrazioneAudio) {
						RegistrazioneAudio reg = (RegistrazioneAudio) medias[res];
						System.out.println();
						reg.play();
						System.out.println();
					} else if (medias[res] instanceof Video) {
						Video vid = (Video) medias[res];
						System.out.println();
						vid.play();
						System.out.println();
					} 
				} else {
					System.out.println();
					System.out.println(">> Nessun elemento trovato all'indice specificato! <<");
					System.out.println();
				}
			} catch (NumberFormatException ex) {
				System.out.println("*****************");
				System.out.println(">> INPUT ERRATO - Scegli fra una delle opzioni disponibili! <<");
				System.out.println("*****************");
			}
		} while (!exit);
	}
}













