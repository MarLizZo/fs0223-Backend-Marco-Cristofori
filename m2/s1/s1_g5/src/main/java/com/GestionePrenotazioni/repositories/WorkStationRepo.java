package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.models.WorkStation;

@Repository
public interface WorkStationRepo extends CrudRepository<WorkStation, Long> {

}
