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
		/*System.out.println();
		
		Set<User> users = new HashSet<User>();
		
		users.add(u_svc.getById(1l));
		svc.saveRes(svc.createResDefault(users, LocalDate.now().plusDays(1), w_svc.getById(1l)));
		users.clear();
		
		users.addAll(List.of(u_svc.getById(4l), u_svc.getById(5l)));
		svc.saveRes(svc.createResDefault(users, LocalDate.now().plusDays(1), w_svc.getById(4l)));
		users.clear();
		
		users.addAll(List.of(u_svc.getById(1l), u_svc.getById(2l), u_svc.getById(3l)));
		svc.saveRes(svc.createResDefault(users, LocalDate.now().plusDays(2), w_svc.getById(5l)));
		users.clear();
		
		users.addAll(List.of(u_svc.getById(1l), u_svc.getById(2l), u_svc.getById(4l), u_svc.getById(5l), u_svc.getById(6l)));
		svc.saveRes(svc.createResDefault(users, LocalDate.of(2023, 8, 20), w_svc.getById(6l)));
		users.clear();
		
		users.addAll(List.of(u_svc.getById(2l)));
		svc.saveRes(svc.createResDefault(users, LocalDate.of(2023, 8, 10), w_svc.getById(2l)));
		
		users.add(u_svc.getById(5l));
		svc.saveRes(svc.createResDefault(users, LocalDate.now().plusMonths(1), w_svc.getById(3l)));
		users.clear();
		
		System.out.println();
		System.out.println(Colors.ANSI_VIOLET_LIGHT + ">> Test same date <<" + Colors.RESET);
		// test same date
		users.addAll(List.of(u_svc.getById(2l)));
		svc.saveRes(svc.createResDefault(users, LocalDate.of(2023, 8, 10), w_svc.getById(10l)));
		users.clear();
		
		System.out.println();
		System.out.println(Colors.ANSI_VIOLET_LIGHT + ">> Test maxSeats reached <<" + Colors.RESET);
		// test maxSeats reached
		users.add(u_svc.getById(4l));
		svc.saveRes(svc.createResDefault(users, LocalDate.now().plusDays(2), w_svc.getById(5l)));
		users.clear();
		
		System.out.println();
		System.out.println(Colors.ANSI_VIOLET_LIGHT + ">> Test update existing Reservation by adding a new User -- Fails if already processed <<"
				+ Colors.RESET);
		// test update existing reservation for a Board Room with available seats
		users.add(u_svc.getById(7l));
		svc.saveRes(svc.createResDefault(users, LocalDate.of(2023, 8, 20), w_svc.getById(6l)));
		users.clear();
		
		System.out.println();
		System.out.println(Colors.ANSI_VIOLET_LIGHT + ">> Test with a Date before Now <<" + Colors.RESET);
		// Test past Date
		users.add(u_svc.getById(1l));
		svc.saveRes(svc.createResDefault(users, LocalDate.of(2023, 7, 20), w_svc.getById(6l)));
		users.clear();
		System.out.println();*/
	}
}
























