package com.GestionePrenotazioni.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.models.Facility;

@Configuration
public class FacilityConfig {

	@Bean("empty_facility")
	@Scope("prototype")
	public Facility facility() {
		return new Facility();
	}
	
	@Bean
	@Scope("prototype")
	public Facility facility_default(String _name, String _address, String _city) {
		Facility f = new Facility();
		return f.builder().name(_name).address(_address).city(_city).build();
	}
}
