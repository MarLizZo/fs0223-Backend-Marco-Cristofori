package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.Facility;

public interface FacilityRepo extends CrudRepository<Facility, Long> {
	public Facility findByNameAndCity(String name, String city);
}
