package com.GestionePrenotazioni.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.Reservation;

public interface ReservationRepo extends CrudRepository<Reservation, Long> {
	
	public List<Reservation> findByDate(LocalDate date);
}
