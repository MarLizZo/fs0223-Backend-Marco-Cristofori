package com.GestionePrenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.configs.FacilityConfig;
import com.GestionePrenotazioni.models.Facility;
import com.GestionePrenotazioni.repositories.FacilityRepo;

@Service
public class FacilityService {
	
	@Autowired FacilityRepo repo;
	@Autowired @Qualifier("empty_facility") private ObjectProvider<Facility> empty_facility;
	
	public Facility createFacility() {
		return empty_facility.getObject();
	}
	
	public Facility createDefaultFacility(String _name, String _address, String _city) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(FacilityConfig.class);
		Facility f = (Facility) appContext.getBean("facility_default", _name, _address, _city);
		appContext.close();
		return f;
	}
	
	public void saveFacility(Facility f) {
		if (repo.findByNameAndCity(f.getName(), f.getCity()) == null) {
			repo.save(f);
			System.out.println("** Facility in " + f.getCity() + " saved correctly **");
		}
	}
	
	public List<Facility> getAll() {
		return (List<Facility>) repo.findAll();
	}
	
	public Facility getById(Long id) {
		Optional<Facility> opt = repo.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}
}
