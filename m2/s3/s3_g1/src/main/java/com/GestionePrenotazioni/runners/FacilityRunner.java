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
		/*System.out.println();
		svc.saveFacility(svc.createDefaultFacility("Code Center", "Via Roma", "Milano", "AB123356"));
		svc.saveFacility(svc.createDefaultFacility("Java Mania", "Via Garibaldi", "Roma", "GE6356"));
		svc.saveFacility(svc.createDefaultFacility("Ex-Code", "Via XXIII Settembre", "Roma", "HH34565"));
		svc.saveFacility(svc.createDefaultFacility("Baracchino Neee", "Via Verdi", "Milano", "UZ765434"));
		svc.saveFacility(svc.createDefaultFacility("ViterbiCode", "Viale degli eroi", "Viterbo", "AZ999754"));
		svc.saveFacility(svc.createDefaultFacility("Uagliò in Code", "Viale della giustizia", "Napoli", "AL00632423"));
		svc.saveFacility(svc.createDefaultFacility("LizZo is Good", "Piazza del teatro", "Viterbo", "OE45674"));
		svc.saveFacility(svc.createDefaultFacility("Umbertone Rules", "Piazza di Spagna", "Roma", "NT224567"));
		svc.saveFacility(svc.createDefaultFacility("Code in Water", "Via Rossini", "Venezia", "DF732667"));
		svc.saveFacility(svc.createDefaultFacility("Focus Code", "XXth Street", "Oslo", "WN100985"));
		System.out.println();*/
	}
}
