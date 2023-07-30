package com.GestionePrenotazioni.runners;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.models.User;
import com.GestionePrenotazioni.services.ReservationService;
import com.GestionePrenotazioni.services.UserService;
import com.GestionePrenotazioni.services.WorkStationService;

@Component
@Order(4)
public class ReservationRunner implements CommandLineRunner {
	
	@Autowired ReservationService svc;
	@Autowired UserService u_svc;
	@Autowired WorkStationService w_svc;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(Colors.ANSI_CYAN + "** .. Reservation Runner running .. **" + Colors.RESET);
		System.out.println();
		
		Set<User> users = new HashSet<User>();
		//svc.saveRes(svc.createResDefault(users, LocalDate.now().plusDays(1), w_svc.getById(1l)));
		users.clear();
		users.addAll(List.of(u_svc.getById(5l), u_svc.getById(4l)));
		svc.saveRes(svc.createResDefault(users, LocalDate.now().plusDays(1), w_svc.getById(5l)));
		
		System.out.println();
	}
}
























