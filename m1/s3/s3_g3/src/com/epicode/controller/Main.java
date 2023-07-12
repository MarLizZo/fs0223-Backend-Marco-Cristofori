package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import com.epicode.enumerations.TipoEvento;
import com.epicode.model.Evento;

public class Main {
	
	public static void main(String[] args) {
		try {
			/* Evento ev_1 = new Evento("Concerto Vasco", LocalDate.of(2023, 8, 11), 
					"Concerto del re del rock italiano", TipoEvento.PUBBLICO, 10000);
			Evento ev_2 = new Evento("Festone Chill", LocalDate.of(2023, 11, 1), 
					"Raduno per gli amanti della chillstep", TipoEvento.PRIVATO, 350);
			Evento ev_3 = new Evento("Lezione di Java", LocalDate.of(2023, 7, 23), 
					"Umberto Emanuele spiega le basi di Java", TipoEvento.PRIVATO, 32);
			
			EventDAO.save(ev_1);
			EventDAO.save(ev_2);
			EventDAO.save(ev_3); */
			
			/* Evento ev = EventDAO.getById(1l);
			System.out.println(ev.toString()); */
			
			Evento ev2 = EventDAO.getById(2l);
			Evento ev3 = EventDAO.getById(3l);
			
			System.out.println(ev2.toString());
			System.out.println(ev3.toString()); 
			
			//EventDAO.deleteById(1l);
			
		} catch (SQLException ex) {
			System.out.println("ERRORE: " + ex.getMessage());
		} finally {
			EventDAO.em.close();
		}
	}

}
