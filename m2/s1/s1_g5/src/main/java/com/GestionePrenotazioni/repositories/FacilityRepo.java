package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.models.Facility;

@Repository
public interface FacilityRepo extends CrudRepository<Facility, Long> {

}
