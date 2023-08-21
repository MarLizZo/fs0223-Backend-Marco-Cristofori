package com.GestionePrenotazioni.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.enums.WSType;
import com.GestionePrenotazioni.models.Facility;
import com.GestionePrenotazioni.models.WorkStation;

@Configuration
public class WorkStationConfig {

	@Bean("empty_workstation")
	@Scope("prototype")
	public WorkStation workStation() {
		return new WorkStation();
	}
	
	@Bean
	@Scope("prototype")
	public WorkStation workStation_default(String _code, String _description, WSType _type, Facility _facility) {
		return new WorkStation(_code, _description, _type, _facility);
	}
}
