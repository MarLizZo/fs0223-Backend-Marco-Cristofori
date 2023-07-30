package com.GestionePrenotazioni.configs;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.models.Reservation;
import com.GestionePrenotazioni.models.User;
import com.GestionePrenotazioni.models.WorkStation;

@Configuration
public class ReservationConfig {

	@Bean("empty_res")
	@Scope("prototype")
	public Reservation reservation() {
		return new Reservation();
	}
	
	@Bean
	@Scope("prototype")
	public Reservation reservation_default(Set<User> _users, LocalDate _date, WorkStation _workStation) {
		Reservation res = new Reservation();
		return res.builder().users(_users).date(_date).workStation(_workStation).build();
	}
}
