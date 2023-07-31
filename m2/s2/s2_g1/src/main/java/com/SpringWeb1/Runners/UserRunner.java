package com.SpringWeb1.Runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SpringWeb1.Services.UserService;

@Component
public class UserRunner implements CommandLineRunner {
	
	@Autowired UserService svc;

	@Override
	public void run(String... args) throws Exception {
		svc.save(svc.createFullUser("Mar.LizZo", "Marco", "Cristofori", 28, "Number One di tutto il mondo nella creazione di Sticker"));
		svc.save(svc.createFullUser("Umbertone Nazionale", "Umberto", "Emanuele", 90, "Il miglior prof di Frosinone"));
		svc.save(svc.createFullUser("GeltrudosaPazza", "Geltrude", "Pazza", 32, "So pazza so pazzaaaaa so pazzaaaaaaaaaaaaaa"));
		svc.save(svc.createFullUser("Gildo41", "Gino", "Del Gildo", 35, "Gino o Gildo, scegliete voi"));
		svc.save(svc.createFullUser("Spinosa", "Giustino", "Istrice", 58, "Una spina nel fianco"));
	}
}
