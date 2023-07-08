package com.epicode.Main;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Main.class);
		System.out.println("Benvenuto Umberto!");
		System.out.println();
		
		//Primo step - init lista
		do {
			try {
				Functions.initializeList();
			} catch (NumberFormatException ex) {
				System.out.println();
				System.out.println("** Per favore non barare, inserisci una delle opzioni disponibili **");
				System.out.println();
			} catch (IOException ex) {
				System.out.println();
				log.error("** Errore imprevisto nel caricare il file ** " + ex.getMessage());
				System.out.println();
				System.out.println("Se stai trollando e hai cancellato il file, ti picchio!");
				System.out.println("Hai la possibilità di salvare il contenuto della lista generata tramite codice più avanti!");
				System.out.println();
			} catch (ExitException ex) {
				System.out.println(ex.getMessage());
				break;
			}
		} while (!Functions.initialized);
		
		
		// Secondo step - scelta operazione
		if (Functions.initialized) {
			System.out.println();
			System.out.println("Molto bene! La lista di libri e riviste è pronta e aspetta di essere smaciullata :)");
			System.out.println();
			
			while (!Functions.exitFlag) {
				try {
					Functions.chooseOperation();
				} catch (NumberFormatException ex) {
					System.out.println();
					System.out.println("Non farmi arrabbiareee. Seleziona una delle opzioni disponibili");
					System.out.println();
				} catch (IOException ex) {
					System.out.println();
					log.error("** Errore nel salvataggio del File ** " + ex.getMessage());
					System.out.println();
				}
			}
		}
	}
}

























