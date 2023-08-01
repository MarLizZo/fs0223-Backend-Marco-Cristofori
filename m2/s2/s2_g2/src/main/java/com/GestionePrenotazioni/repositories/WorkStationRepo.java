package com.GestionePrenotazioni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.enums.WSType;
import com.GestionePrenotazioni.models.WorkStation;

public interface WorkStationRepo extends CrudRepository<WorkStation, Long> {
	
	public WorkStation findByCode(String code);
	
	@Query("SELECT w FROM WorkStation w WHERE w.type = :ofType")
	public List<WorkStation> findByType(WSType ofType);
	
	@Query("SELECT w FROM WorkStation w WHERE w.type = :inCity")
	public List<WorkStation> findByCity(String inCity);
	
	@Query("SELECT w FROM WorkStation w WHERE w.type = :ofType AND w.facility.city = :inCity")
	public List<WorkStation> findByTypeAndCity(WSType ofType, String inCity);
}
