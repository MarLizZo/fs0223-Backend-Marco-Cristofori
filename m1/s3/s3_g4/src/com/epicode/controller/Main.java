package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.epicode.enumerations.Conferma;
import com.epicode.enumerations.Genere;
import com.epicode.enumerations.Sesso;
import com.epicode.enumerations.TipoEvento;
import com.epicode.model.Concerto;
import com.epicode.model.Evento;
import com.epicode.model.Location;
import com.epicode.model.Partecipazione;
import com.epicode.model.Persona;

public class Main {
	
	public static void main(String[] args) {
		/*Location loc_1 = new Location("Stadio San Siro", "Milano");
		Location loc_2 = new Location("Stadio Olimpico", "Roma");
		Location loc_3 = new Location("Baracchino", "Proprio li");
		
		Persona per_1 = new Persona("Marko", "LizZo", "liz@lez.com", LocalDate.of(1990, 1, 1), Sesso.MASCHIO);
		Persona per_2 = new Persona("Umberto", "Emanuele", "umb@ema.com", LocalDate.of(1985, 5, 5), Sesso.MASCHIO);
		Persona per_3 = new Persona("Geltrude", "Strana", "gel@str.com", LocalDate.of(1992, 7, 9), Sesso.FEMMINA);
		
		Evento ev_1 = new Evento("Concerto Vasco", LocalDate.of(2023, 9, 2), "Super converto Live Vasco", TipoEvento.PUBBLICO, 5000, loc_1);
		Evento ev_2 = new Evento("Concerto Metallica", LocalDate.of(2023, 11, 4), "Live Metallica Roma", TipoEvento.PUBBLICO, 9000, loc_2);
		Evento ev_3 = new Evento("Meeting AI", LocalDate.of(2023, 7, 12), "Intellettuali e Nerd", TipoEvento.PRIVATO, 45, loc_3);
		
		Partecipazione part_1 = new Partecipazione(per_1, ev_1, Conferma.CONFERMATA);
		Partecipazione part_2 = new Partecipazione(per_1, ev_2, Conferma.DA_CONFERMARE);
		Partecipazione part_3 = new Partecipazione(per_2, ev_2, Conferma.CONFERMATA);
		Partecipazione part_4 = new Partecipazione(per_2, ev_3, Conferma.CONFERMATA);
		Partecipazione part_5 = new Partecipazione(per_3, ev_1, Conferma.DA_CONFERMARE);*/
		
		//Concerto c1 = new Concerto("Concerto Vasco", LocalDate.of(2023, 9, 2), "Super converto Live Vasco", TipoEvento.PUBBLICO, 5000, loc_1, Genere.ROCK, false);
		
		//System.out.println(loc_1);
		//System.out.println(per_1);
		//System.out.println(ev_1);
		//System.out.println(part_1);
		
		try {
			/*PersonaDAO.save(per_1);
			PersonaDAO.save(per_2);
			PersonaDAO.save(per_3);
			LocationDAO.save(loc_1);
			LocationDAO.save(loc_2);
			LocationDAO.save(loc_3);
			ConcertoDAO.save(c1);
			EventDAO.save(ev_1);
			EventDAO.save(ev_2);
			EventDAO.save(ev_3);
			PartecipazioneDAO.save(part_1);
			PartecipazioneDAO.save(part_2);
			PartecipazioneDAO.save(part_3);
			PartecipazioneDAO.save(part_4);
			PartecipazioneDAO.save(part_5);*/
			//System.out.println(PersonaDAO.getById(1l));
			//System.out.println(LocationDAO.getById(1l));
			//System.out.println(PartecipazioneDAO.getById(1l));
			//System.out.println(EventDAO.getById(1l));
			//Location l = LocationDAO.getById(2l);
			//Concerto c = new Concerto("Concerto Ligabue", LocalDate.of(2023, 11, 7), "Super concerto di Liga", TipoEvento.PUBBLICO, 7000, l, Genere.ROCK, true);
			//ConcertoDAO.save(c);
			
			/*List<Concerto> ls = EventDAO.getConcertiInStreaming();
			if (ls.size() > 0) {
				ls.forEach(el -> System.out.println(el));
			} else {
				System.out.println("** No elements found");
			}*/
			
			/*List<Concerto> lst = EventDAO.getConcertiPerTipo(Genere.ROCK);
			if (lst.size() > 0) {
				lst.forEach(el -> System.out.println(el));
			} else {
				System.out.println("** No elements found");
			}*/
			
		} //catch (SQLException ex) {
			//System.out.println("ERRORE: " + ex.getMessage());
		//} 
		finally {
			/*EventDAO.em.close();
			LocationDAO.em.close();
			PartecipazioneDAO.em.close();
			PersonaDAO.em.close();
			ConcertoDAO.em.close();*/
		}
		
	}
}
