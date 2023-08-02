package com.GestionePrenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.configs.WorkStationConfig;
import com.GestionePrenotazioni.enums.WSType;
import com.GestionePrenotazioni.models.Facility;
import com.GestionePrenotazioni.models.WorkStation;
import com.GestionePrenotazioni.repositories.WorkStationRepo;

@Service
public class WorkStationService {
	@Autowired WorkStationRepo repo;
	@Autowired @Qualifier("empty_workstation") private ObjectProvider<WorkStation> empty_ws;
	
	public WorkStation createWorkStation() {
		return empty_ws.getObject();
	}
	
	public WorkStation createCompleteWorkStation(String _code, String _description, WSType _type, Facility _facility) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(WorkStationConfig.class);
		WorkStation w = (WorkStation) appContext.getBean("workStation_default", _code, _description, _type, _facility);
		appContext.close();
		return w;
	}
	
	public void saveWS(WorkStation w) {
		if (repo.findByCode(w.getCode()) == null) {
			repo.save(w);
			System.out.println("** WorkStation " + w.getCode() + " saved correctly **");
		} else {
			//
		}
	}
	
	public WorkStation getById(Long id) {
		Optional<WorkStation> opt = repo.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}
	
	public List<WorkStation> getAll() {
		return (List<WorkStation>) repo.findAll();
	}
	
	public List<WorkStation> getByTypeAndCity(WSType type, String city) {
		return repo.findByTypeAndCity(type, city);
	}
}

























