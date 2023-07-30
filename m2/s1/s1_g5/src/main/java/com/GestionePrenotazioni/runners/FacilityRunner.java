package com.GestionePrenotazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.services.FacilityService;

@Component
@Order(2)
public class FacilityRunner implements CommandLineRunner {
	
	@Autowired FacilityService svc;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(Colors.ANSI_CYAN + "** .. Facility Runner running .. **" + Colors.RESET);
		System.out.println();
		/*svc.saveFacility(svc.createDefaultFacility("Via Roma", "Milano"));
		svc.saveFacility(svc.createDefaultFacility("Via Garibaldi", "Roma"));
		svc.saveFacility(svc.createDefaultFacility("Via XXIII Settembre", "Roma"));
		svc.saveFacility(svc.createDefaultFacility("Via Verdi", "Milano"));
		svc.saveFacility(svc.createDefaultFacility("Viale degli eroi", "Viterbo"));
		svc.saveFacility(svc.createDefaultFacility("Viale della giustizia", "Napoli"));
		svc.saveFacility(svc.createDefaultFacility("Piazza del teatro", "Viterbo"));
		svc.saveFacility(svc.createDefaultFacility("Piazza di Spagna", "Roma"));
		svc.saveFacility(svc.createDefaultFacility("Via Rossini", "Venezia"));*/
	}
}
