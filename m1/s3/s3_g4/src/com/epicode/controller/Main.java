package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.epicode.enumerations.Conferma;
import com.epicode.enumerations.Sesso;
import com.epicode.enumerations.TipoEvento;
import com.epicode.model.Evento;
import com.epicode.model.Location;
import com.epicode.model.Partecipazione;
import com.epicode.model.Persona;

public class Main {
	
	public static void main(String[] args) {
		Location loc_1 = new Location("Stadio San Siro", "Milano");
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
		Partecipazione part_5 = new Partecipazione(per_3, ev_1, Conferma.DA_CONFERMARE);
		
		//System.out.println(loc_1);
		//System.out.println(per_1);
		//System.out.println(ev_1);
		//System.out.println(part_1);
		
		try {
			PersonaDAO.save(per_1);
		} catch (SQLException ex) {
			System.out.println("ERRORE: " + ex.getMessage());
		} finally {
			PersonaDAO.em.close();
		}
		
	}
}
