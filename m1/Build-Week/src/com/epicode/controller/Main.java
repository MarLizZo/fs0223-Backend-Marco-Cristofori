package com.epicode.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;

import com.epicode.enumerators.Citta;
import com.epicode.enumerators.Genere;
import com.epicode.enumerators.Periodicita;
import com.epicode.enumerators.TipoMezzo;
import com.epicode.model.Abbonamento;
import com.epicode.model.Biglietteria;
import com.epicode.model.BigliettiConvalidati;
import com.epicode.model.Biglietto;
import com.epicode.model.Colors;
import com.epicode.model.DistributoreAutomatico;
import com.epicode.model.Manutenzione;
import com.epicode.model.Mezzo;
import com.epicode.model.RivenditoreAutorizzato;
import com.epicode.model.Tessera;
import com.epicode.model.TitoloDiViaggio;
import com.epicode.model.Tratta;
import com.epicode.model.Utente;
import com.epicode.controller.BiglietteriaDAO;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		System.out.println();
		System.out.println(Colors.BOLD + Colors.ANSI_LIGHT_BLUE + ">> Benvenuti! <<");
		System.out.println();
		
		 while (true) {
			try {
				
				// STEP 1: Utenti e tessere
				
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + Colors.BOLD + "Premi Invio per istanziare gli utenti del nostro portale " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				//istanziaUtenti();
				System.out.println();
				System.out.println(Colors.ANSI_VIOLET_LIGHT + Colors.BOLD + "Utenti salvati nel Database, ecco la lista: ");
				System.out.println(Colors.RESET + Colors.BOLD);
				Thread.sleep(500);
				UtenteDAO.getAll().forEach(u -> System.out.println(u));
				System.out.println();
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + "Ora assegniamo delle tessere agli utenti, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				//istanziaTessere();
				System.out.println(Colors.RESET + Colors.BOLD);
				System.out.println(Colors.ANSI_VIOLET_LIGHT + "Tessere salvate ed associate agli utenti!");
				System.out.println();
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + Colors.BOLD + "Ora passiamo alla biglietteria! Premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				
				
				
				// STEP 2: Distributori e Rivenditori
				
				//istanziaBiglietterie();
				System.out.println(Colors.RESET + Colors.BOLD);
				System.out.println(Colors.ANSI_VIOLET_LIGHT + "Rivenditori e Distributori salvati nel Database, ecco la lista: ");
				System.out.println(Colors.RESET + Colors.BOLD);
				Thread.sleep(500);
				List<Biglietteria> lb = BiglietteriaDAO.getAllBiglietteria();
				lb.forEach(b -> System.out.println(b));
				System.out.println();
				Thread.sleep(1000);
				
				
				
				// STEP 3: Tratte e Mezzi
				
				System.out.print(Colors.ANSI_CYAN + "Passiamo alle tratte disponibili e i Mezzi, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				//istanziaTratteEMezzi();
				System.out.println();
				System.out.println(Colors.ANSI_VIOLET_LIGHT + "Tratte e Mezzi salvati nel Database, siamo quasi pronti per viaggiare!");
				System.out.println(Colors.RESET + Colors.BOLD);
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + "Vediamo la lista delle tratte disponibili, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				TrattaDAO.getAll().forEach(t -> System.out.println(t));
				System.out.println();
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + "Vediamo la lista dei nostri mezzi, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				MezzoDAO.getAll().forEach(m -> System.out.println(m));
				System.out.println();
				Thread.sleep(1000);
				
				
				
				// STEP 4: Biglietti e Abbonamenti
				
				System.out.print(Colors.ANSI_CYAN + "Ora vediamo di vendere un po di biglietti e abbonamenti, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				//istanziaBigliettiAbbonamenti();
				System.out.println(Colors.RESET + Colors.BOLD);
				System.out.println(Colors.ANSI_VIOLET_LIGHT + "Biglietti e abbonamenti venduti! Diventeremo milionari :)");
				Thread.sleep(1000);
				System.out.println();
				System.out.print(Colors.ANSI_CYAN + "Vediamo la lista di biglietti e abbonamenti venduti, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				TitoloDiViaggioDAO.getTitoliVenduti().forEach(t -> System.out.println(t));
				System.out.println(Colors.RESET + Colors.BOLD);
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + "Vediamo quanti biglietti e abbonamenti hanno venduto i vari rivenditori e distributori, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				BiglietteriaDAO.getAllBiglietteria().forEach(el -> BiglietteriaDAO.getTitoliEmessi(el));
				System.out.println();
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + "Vediamo i biglietti venduti dal > 01 luglio 2023 < fino ad oggi, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				BiglietteriaDAO.trovaAbbonamentiPerPeriodo(LocalDate.of(2023, 07, 1), LocalDate.now()).forEach(el -> System.out.println(el));
				System.out.println();
				Thread.sleep(1000);
				
				
				
				
				// STEP 5: Manutenzioni
				
				System.out.print(Colors.ANSI_CYAN + "Alcuni mezzi sono stanchi, li mandiamo in manutenzione? Premi invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				//istanziaManutenzioni();
				System.out.println();
				Thread.sleep(1000);
				System.out.println(Colors.ANSI_VIOLET_LIGHT + "Alcuni mezzi ora sono in manutenzione, ed altri sono gia stati riparati.");
				System.out.println();
				System.out.print(Colors.ANSI_CYAN + "Cerchiamo le manutenzioni registrate dal giorno 01 Marzo 2023 al 18 Luglio 2023, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				ManutenzioneDAO.trovaManutenzionePerPeriodo(LocalDate.of(2023, 3, 1), LocalDate.of(2023, 7, 18)).forEach(m -> System.out.println(m));
				System.out.println();
				Thread.sleep(1000);
				
				
				
				// STEP 6: Timbro dei biglietti
				System.out.print(Colors.ANSI_CYAN + "Direi che e quasi ora di partire, convalidiamo i biglietti! Premi invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				//istanziaConvalidaBiglietti();
				System.out.println();
				System.out.println(Colors.ANSI_VIOLET_LIGHT + "Biglietti convalidati, ora possiamo finalmente viaggiare!");
				System.out.println();
				Thread.sleep(1000);
				
				
				
				// STEP 7: Percorri tratte
				System.out.print(Colors.ANSI_CYAN + "Siamo pronti, si parteee! Premi invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				//percorriTratte();
				System.out.println();
				Thread.sleep(1500);
				System.out.println(Colors.ANSI_VIOLET_LIGHT + "Wow, sembra che funziona tutto. Mercurio e il nome piu bello del mondo! :)");
				System.out.println(Colors.RESET + Colors.BOLD);
				Thread.sleep(1000);
				System.out.println(Colors.ANSI_LIGHT_BLUE + "Sezione Extra");
				System.out.println(Colors.RESET + Colors.BOLD);
				//verificaValiditaAbbonamento();
				System.out.println();
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + "Vediamo i biglietti convalidati dal giorno 15 luglio ad oggi, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				BigliettiConvalidatiDAO.convalidatiPerData(LocalDate.of(2023, 7, 15), LocalDate.now()).forEach(b -> System.out.println(b));
				System.out.println();
				Thread.sleep(1000);
				System.out.print(Colors.ANSI_CYAN + "Vediamo quanti biglietti sono stati timbrati su ogni mezzo, premi Invio " + Colors.RESET + Colors.BOLD);
				sc.nextLine();
				System.out.println();
				List<Mezzo> lsm = MezzoDAO.getAll();
				lsm.forEach(m -> System.out.println("Il mezzo " + m.getTipoMezzo() + " " + m.getMarca() + " ha timbrato" 
						+ Colors.ANSI_VIOLET_LIGHT + " > " + BigliettiConvalidatiDAO.convalidatiSuMezzo(m.getId()).size() + " < " 
						+ Colors.RESET + Colors.BOLD + " biglietti"));
			} catch (InterruptedException ex) {
				System.out.println(Colors.ANSI_RED_DANGER + "Java è buggato, non è colpa nostra!" + Colors.RESET + Colors.BOLD);
			}
			
			break;
		}
		
	}
	
	public static void istanziaUtenti() {
		Utente u1 = new Utente ("Marco", "Lizzo", LocalDate.of(1990, 05, 23), "Roma", Genere.MASCHIO);
		Utente u2 = new Utente ("Vincenzo", "Salzano", LocalDate.of(1993, 05, 23), "Napoli", Genere.MASCHIO);
		Utente u3 = new Utente ("Mercurio", "De Luca", LocalDate.of(2000, 02, 22), "Milano", Genere.MASCHIO);
		Utente u4 = new Utente ("Umberto", "Emanuele", LocalDate.of(1988, 05, 3), "Frosinone", Genere.MASCHIO);
		Utente u5 = new Utente ("Geltrude", "Pazza", LocalDate.of(1998, 10, 12), "Cosenza", Genere.FEMMINA);
		
		UtenteDAO.save(u1);
		UtenteDAO.save(u2);
		UtenteDAO.save(u3);
		UtenteDAO.save(u4);
		UtenteDAO.save(u5);
	}
	
	public static void istanziaTessere() {
		Utente u1 = UtenteDAO.getById(1);
		Utente u2 = UtenteDAO.getById(2);
		Utente u3 = UtenteDAO.getById(3);
		Utente u4 = UtenteDAO.getById(4);
		Utente u5 = UtenteDAO.getById(5);
		
		Tessera t1 = new Tessera(u1, "cod-123");
		Tessera t2 = new Tessera(u2, "cod-234");
		Tessera t3 = new Tessera(u3, "cod-345");
		Tessera t4 = new Tessera(u2, "cod-456");
		Tessera t5 = new Tessera(u3, "cod-567");
		
		TesseraDAO.save(t1);
		TesseraDAO.save(t2);
		TesseraDAO.save(t3);
		TesseraDAO.save(t4);
		TesseraDAO.save(t5);
		
		u1.setTesseraUtente(TesseraDAO.getById(1));
		u2.setTesseraUtente(TesseraDAO.getById(2));
		u3.setTesseraUtente(TesseraDAO.getById(3));
		u4.setTesseraUtente(TesseraDAO.getById(4));
		u5.setTesseraUtente(TesseraDAO.getById(5));
		
		UtenteDAO.update(u1);
		UtenteDAO.update(u2);
		UtenteDAO.update(u3);
		UtenteDAO.update(u4);
		UtenteDAO.update(u5);
	}
	
	public static void istanziaBiglietterie() {
		Biglietteria d1 = new DistributoreAutomatico("Roma", "dist_123", true);
		Biglietteria d2 = new DistributoreAutomatico("Milano", "dist_234", true);
		Biglietteria d3 = new DistributoreAutomatico("Firenze", "dist_678", false);
		
		Biglietteria r1 = new RivenditoreAutorizzato("Roma", "Tabaccheria centrale", "Anonimo");
		Biglietteria r2 = new RivenditoreAutorizzato("Venezia", "Edicola luxury", "Geltrude");
		Biglietteria r3 = new RivenditoreAutorizzato("Palermo", "Bar Carletto", "Carlo");
		
		BiglietteriaDAO.save(d1);
		BiglietteriaDAO.save(d2);
		BiglietteriaDAO.save(d3);
		BiglietteriaDAO.save(r1);
		BiglietteriaDAO.save(r2);
		BiglietteriaDAO.save(r3);
	}
	
	public static void istanziaTratteEMezzi() {
		Tratta t1 = new Tratta(Citta.ROMA, Citta.MILANO, false);		
		Tratta t2 = new Tratta(Citta.ROMA, Citta.VITERBO, false);		
		Tratta t3 = new Tratta(Citta.NAPOLI, Citta.VENEZIA, false);		
		Tratta t4 = new Tratta(Citta.PALERMO, Citta.NAPOLI, false);		
		Tratta t5 = new Tratta(Citta.BERGAMO, Citta.MILANO, false);		
		Tratta t6 = new Tratta(Citta.FROSINONE, Citta.VERONA, false);
		
		TrattaDAO.save(t1);
		TrattaDAO.save(t2);
		TrattaDAO.save(t3);
		TrattaDAO.save(t4);
		TrattaDAO.save(t5);
		TrattaDAO.save(t6);
		
		List<Tratta> lt1 = new ArrayList<Tratta>(); lt1.add(t1); lt1.add(t3); lt1.add(t6); 
		List<Tratta> lt2 = new ArrayList<Tratta>(); lt1.add(t2); lt1.add(t3); lt1.add(t4); 
		List<Tratta> lt3 = new ArrayList<Tratta>(); lt1.add(t1); lt1.add(t5); lt1.add(t6); 
		List<Tratta> lt4 = new ArrayList<Tratta>(); lt1.add(t4); lt1.add(t5); lt1.add(t2); 
		List<Tratta> lt5 = new ArrayList<Tratta>(); lt1.add(t2); lt1.add(t4); lt1.add(t5); 
		List<Tratta> lt6 = new ArrayList<Tratta>(); lt1.add(t1); lt1.add(t5); lt1.add(t3); 
		
		
		Mezzo m1 = new Mezzo (TipoMezzo.AUTOBUS, 2010, "Ferrari", lt1);
		Mezzo m2 = new Mezzo (TipoMezzo.TRAM, 2018, "Lamborghini", lt2);
		Mezzo m3 = new Mezzo (TipoMezzo.AUTOBUS, 2012, "Maserati", lt3);
		Mezzo m4 = new Mezzo (TipoMezzo.TRAM, 2020, "BMW", lt4);
		Mezzo m5 = new Mezzo (TipoMezzo.AUTOBUS, 2015, "Mercedes", lt5);
		Mezzo m6 = new Mezzo (TipoMezzo.TRAM, 2022, "Tesla", lt6);
		
		MezzoDAO.save(m1);
		MezzoDAO.save(m2);
		MezzoDAO.save(m3);
		MezzoDAO.save(m4);
		MezzoDAO.save(m5);
		MezzoDAO.save(m6);
	}
	
	public static void istanziaBigliettiAbbonamenti() {
		TitoloDiViaggio b1 = new Biglietto ("98dhxaoehb823", LocalDate.now(), BiglietteriaDAO.getByName("Bar Carletto"), TrattaDAO.getById(1), UtenteDAO.getById(1));
		TitoloDiViaggio a1 = new Abbonamento ("343298hfdhdf8", LocalDate.of(2023, 7, 4), BiglietteriaDAO.getByCodName("dist_123"), TrattaDAO.getById(2), Periodicita.MENSILE, TesseraDAO.getById(1));
		TitoloDiViaggio b2 = new Biglietto ("76ghddtrh813", LocalDate.of(2023, 6, 21), BiglietteriaDAO.getByCodName("dist_123"), TrattaDAO.getById(1), UtenteDAO.getById(2));
		TitoloDiViaggio a2 = new Abbonamento ("790291hfgtdf2", LocalDate.of(2023, 6, 1), BiglietteriaDAO.getByCodName("dist_234"), TrattaDAO.getById(3), Periodicita.SETTIMANALE, TesseraDAO.getById(2));  
		TitoloDiViaggio b3 = new Biglietto ("34gtryoh800", LocalDate.of(2023, 7, 14), BiglietteriaDAO.getByCodName("dist_123"), TrattaDAO.getById(4), UtenteDAO.getById(4));
		TitoloDiViaggio a3 = new Abbonamento ("745592hfgtd21", LocalDate.of(2023, 5, 8), BiglietteriaDAO.getByName("Edicola luxury"), TrattaDAO.getById(6), Periodicita.SETTIMANALE, TesseraDAO.getById(3));    
		TitoloDiViaggio b4 = new Biglietto ("544abyoh711", LocalDate.of(2023, 6, 14), BiglietteriaDAO.getByName("Edicola luxury"), TrattaDAO.getById(1), UtenteDAO.getById(5));
		TitoloDiViaggio a4 = new Abbonamento ("890543hfgtd55", LocalDate.of(2023, 4, 11), BiglietteriaDAO.getByName("Tabaccheria centrale"), TrattaDAO.getById(6), Periodicita.MENSILE, TesseraDAO.getById(4));
		
		TitoloDiViaggioDAO.save(b1);
		TitoloDiViaggioDAO.save(a1);
		TitoloDiViaggioDAO.save(b2);
		TitoloDiViaggioDAO.save(a2);
		TitoloDiViaggioDAO.save(b3);
		TitoloDiViaggioDAO.save(a3);
		TitoloDiViaggioDAO.save(b4);
		TitoloDiViaggioDAO.save(a4);
	}

	public static void istanziaManutenzioni() {
		Manutenzione man1 = new Manutenzione (MezzoDAO.getById(1), LocalDate.of(2023, 6, 10), LocalDate.of(2023, 7, 12));
		Manutenzione man2 = new Manutenzione (MezzoDAO.getById(2), LocalDate.of(2023, 4, 2), LocalDate.of(2023, 4, 22));
		
		Manutenzione man3 = new Manutenzione (MezzoDAO.getById(3), LocalDate.of(2023, 7, 10), null);
		Manutenzione man4 = new Manutenzione (MezzoDAO.getById(4), LocalDate.of(2023, 7, 16), null);

		Manutenzione man5 = new Manutenzione (MezzoDAO.getById(5), LocalDate.of(2022, 11, 12), LocalDate.of(2023, 1, 10));
		
		Mezzo me3 = MezzoDAO.getById(3);
		Mezzo me4 = MezzoDAO.getById(4);
		
		ManutenzioneDAO.save(man1);
		ManutenzioneDAO.save(man2);
		ManutenzioneDAO.save(man3);
		ManutenzioneDAO.save(man4);
		ManutenzioneDAO.save(man5);
		
		me3.setInServizio(false);
		me4.setInServizio(false);
		
		MezzoDAO.update(me3);
		MezzoDAO.update(me4);
	}

	public static void istanziaConvalidaBiglietti() {
		Biglietto bt = TitoloDiViaggioDAO.getBigliettoByCodice("98dhxaoehb823");
		Biglietto bt2 = TitoloDiViaggioDAO.getBigliettoByCodice("76ghddtrh813");
		Biglietto bt3 = TitoloDiViaggioDAO.getBigliettoByCodice("34gtryoh800");
		Biglietto bt4 = TitoloDiViaggioDAO.getBigliettoByCodice("544abyoh711");
		
		BigliettiConvalidati bc1 = new BigliettiConvalidati (MezzoDAO.getById(2), bt, LocalDate.of(2023, 7, 16));
		BigliettiConvalidati bc2 = new BigliettiConvalidati (MezzoDAO.getById(2), bt2, LocalDate.of(2023, 7, 16));
		BigliettiConvalidati bc3 = new BigliettiConvalidati (MezzoDAO.getById(3), bt3, LocalDate.of(2023, 6, 10));
		BigliettiConvalidati bc4 = new BigliettiConvalidati (MezzoDAO.getById(6), bt4, LocalDate.of(2023, 7, 19));
		
		BigliettiConvalidatiDAO.save(bc1, bt);
		BigliettiConvalidatiDAO.save(bc2, bt2);
		BigliettiConvalidatiDAO.save(bc3, bt3);
		BigliettiConvalidatiDAO.save(bc4, bt4);
	}

	public static void percorriTratte() {
		MezzoDAO.percorriTratta(TrattaDAO.getById(3), MezzoDAO.getById(1));
		MezzoDAO.percorriTratta(TrattaDAO.getById(4), MezzoDAO.getById(2));
		MezzoDAO.percorriTratta(TrattaDAO.getById(1), MezzoDAO.getById(6));
	}
	
	public static void verificaValiditaAbbonamento() {
		System.out.print("Inserisci un codice tessera utente per verificare abbonamenti collegati: ");
		String str = sc.nextLine();
		TitoloDiViaggioDAO.verificaAbbonamento(str);
	}
}

























