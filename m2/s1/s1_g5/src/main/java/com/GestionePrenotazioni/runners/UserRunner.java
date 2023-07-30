package com.GestionePrenotazioni.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.services.UserService;

@Component
@Order(1)
public class UserRunner implements CommandLineRunner {
	@Autowired UserService svc;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println(Colors.ANSI_CYAN + "** .. User Runner running .. **" + Colors.RESET);
		System.out.println();
		svc.saveUser(svc.createUser("Mar.LizZo", "Marco", "Cristofori", "email@lizz.it"));
		svc.saveUser(svc.createUser("Umbertone Nazionale", "Umberto", "Emanuele", "emaberto@gg.it"));
		svc.saveUser(svc.createUser("Geltrudosa", "Geltrude", "Pazza", "pazzia@asl.it"));
		svc.saveUser(svc.createUser("Spina nel fianco", "Gino", "Spinosa", "istrice@wwf.it"));
		svc.saveUser(svc.createUser("Shadow", "Eminence", "Shadow", "black@aldila.org"));
		svc.saveUser(svc.createUser("Pino la lavatrice", "Pino", "Lavatrice", "lalavatrice@eheh.it"));
		svc.saveUser(svc.createUser("Gigliola90", "Gigliola", "Stramba", "giglia9090@strange.com"));
		svc.saveUser(svc.createUser("TesterInfallibile", "Giustino", "Giustozzi", "scovabug@senior.com"));
		svc.saveUser(svc.createUser("Kira", "Light", "Yagami", "ryuk@shinigami.net"));
		System.out.println();
	}
}
