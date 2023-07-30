package com.GestionePrenotazioni.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.models.Reservation;
import com.GestionePrenotazioni.models.User;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation, Long> {
	
	public List<Reservation> findByDate(LocalDate date);
}
