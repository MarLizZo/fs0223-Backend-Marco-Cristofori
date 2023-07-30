package com.GestionePrenotazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.enums.WSType;
import com.GestionePrenotazioni.services.FacilityService;
import com.GestionePrenotazioni.services.WorkStationService;

@Component
@Order(3)
public class WorkStationRunner implements CommandLineRunner {
	@Autowired WorkStationService svc;
	@Autowired FacilityService f_svc;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(Colors.ANSI_CYAN + "** .. WorkStation Runner running .. **" + Colors.RESET);
		System.out.println();
		svc.saveWS(svc.createCompleteWorkStation("WS-1-Single-123", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(1l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-1-Single-234", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(1l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-1-Single-345", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(1l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-1-Open-123", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(1l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-1-Open-234", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(1l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-1-Room-123", "Board Room for Council", WSType.BOARDROOM, f_svc.getById(1l)));
		
		svc.saveWS(svc.createCompleteWorkStation("WS-2-Single-123", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(2l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-2-Single-456", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(2l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-2-Open-123", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(2l)));
		
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Single-123", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(3l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Single-345", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(3l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Single-456", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(3l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Open-123", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(3l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Open-234", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(3l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Open-345", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(3l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Open-456", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(3l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-3-Room-123", "Board Room for Council", WSType.BOARDROOM, f_svc.getById(3l)));
		
		svc.saveWS(svc.createCompleteWorkStation("WS-4-Single-123", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(4l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-4-Single-234", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(4l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-4-Single-345", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(4l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-4-Single-456", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(4l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-4-Single-567", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(4l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-4-Open-123", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(4l)));

		svc.saveWS(svc.createCompleteWorkStation("WS-5-Single-123", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(5l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-5-Single-234", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(5l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-5-Single-345", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(5l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-5-Open-123", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(5l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-5-Open-234", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(5l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-5-Open-345", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(5l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-5-Open-456", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(5l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-5-Room-123", "Board Room for Council", WSType.BOARDROOM, f_svc.getById(5l)));
		
		svc.saveWS(svc.createCompleteWorkStation("WS-6-Single-123", "Single WS for Focus", WSType.PRIVATE, f_svc.getById(6l)));
		svc.saveWS(svc.createCompleteWorkStation("WS-6-Open-123", "Open Space for Team", WSType.OPENSPACE, f_svc.getById(6l)));
		
		System.out.println();
		System.out.println(Colors.ANSI_VIOLET_LIGHT + ">> List all Work Stations with Type 'OPENSPACE' in City 'Roma' <<" + Colors.RESET);
		System.out.println();
		
		// list all WS with specific Type and City
		svc.getByTypeAndCity(WSType.OPENSPACE, "Roma").forEach(el -> System.out.println(el));
		
		System.out.println();
	}
}
