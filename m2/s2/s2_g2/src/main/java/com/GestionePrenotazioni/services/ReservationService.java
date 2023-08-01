package com.GestionePrenotazioni.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.configs.ReservationConfig;
import com.GestionePrenotazioni.models.Reservation;
import com.GestionePrenotazioni.models.User;
import com.GestionePrenotazioni.models.WorkStation;
import com.GestionePrenotazioni.repositories.ReservationRepo;

@Service
public class ReservationService {
	@Autowired ReservationRepo repo;
	@Autowired @Qualifier("empty_res") private ObjectProvider<Reservation> empty_res;
	
	public Reservation createRes() {
		return empty_res.getObject();
	}
	
	public Reservation createResDefault(Set<User> _users, LocalDate _date, WorkStation _workStation) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ReservationConfig.class);
		Reservation res = (Reservation) appContext.getBean("reservation_default", _users, _date, _workStation);
		appContext.close();
		return res;
	}
	
	public List<Reservation> getAll() {
		return (List<Reservation>) repo.findAll();
	}
	
	public Reservation getById(Long id) {
		Optional<Reservation> opt = repo.findById(id);
		return opt.isPresent() ? opt.get() : null;
	}
	
	public List<Reservation> getByDate(LocalDate date) {
		return repo.findByDate(date);
	}
	
	// Il Super Saiyan dei Metodi :)
	// ho usato Java per fare tutti i check, da delle Query sarebbe stato impossibile (per me)
	public void saveRes(Reservation res) {
		
		if (res.getDate().isBefore(LocalDate.now())) {
			System.out.println(Colors.ANSI_RED_DANGER + "** Time machine not yet invented.. I'm working on it. **" + Colors.RESET);
			return;
		}
		
		List<Reservation> r = getByDate(res.getDate());
		
		// if no reservations for date are found, create new reservation
		if (r.size() == 0) {
			repo.save(res);
			System.out.println("** New Reservation for " + res.getWorkStation().getCode() + " on Date "
					+ res.getDate().toString() + " saved correctly **");
		} else {
			
			// cycle users passed as parameter inside the res instance to check all the cases
			for (User user : res.getUsers()) {
				
				// refresh list
				r = getByDate(res.getDate());
				
				// if users already booked a Work Station for date
				if (r.stream().anyMatch(el -> el.getUsers().stream().anyMatch(us -> us.getUsername().equals(user.getUsername())))) {
					//
				} else {
					
					 //if reservations per date exist, and if reservation for specific Work Station exists
					if (r.stream().anyMatch(re -> re.getWorkStation().getCode().equals(res.getWorkStation().getCode()))) {
						Reservation match = r.stream()
								.filter(el -> el.getWorkStation().getCode().equals(res.getWorkStation().getCode()))
								.collect(Collectors.toList()).get(0);
						
						// check if max seats is reached
						if (match.getWorkStation().getMaxSeats() <= match.getUsers().size()) {
							//
						} else {
							
							// update the matched Reservation by adding the new User from the passed object
							match.getUsers().add(user);
							repo.save(match);
							System.out.println("** Reservation for Date " + res.getDate().toString() + " updated correctly **");
						}
					} else {
						
						// save new Reservation with the same Date but for different Work Station
						repo.save(res);
						System.out.println("** New Reservation for " + res.getWorkStation().getCode() + " on Date "
								+ res.getDate().toString() + " saved correctly **");
					}
				}
			}
		}
	}
}























