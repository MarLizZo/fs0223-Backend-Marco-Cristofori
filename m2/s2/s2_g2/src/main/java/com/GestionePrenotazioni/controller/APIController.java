package com.GestionePrenotazioni.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GestionePrenotazioni.models.User;
import com.GestionePrenotazioni.services.UserService;

@RestController
@RequestMapping("/api")
public class APIController {
	
	@Autowired UserService user_svc;
	
	@GetMapping("/info")
	public String getInfo(@RequestParam String lang) {
		String info = 
			lang.equals("it") ? 
			"Un utente può prenotare una sola postazione per un giorno specifico. E' possibile prenotare una postazione solo se ha posti liberi." 
			: lang.equals("en") ?
			"An User can book a single Work station for a specific day. It's possible to book a Work station only if it has available seats."
			: 
			"Error, language not recognized";
		
		return info;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> ls = user_svc.getAll();
		//ls.forEach(el -> el.setReservations(null));
		return new ResponseEntity<List<User>>(ls, HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		try {
			User u = user_svc.getById(id);
			//u.setReservations(null);
			return new ResponseEntity<User>(u, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<?> createUser(@RequestBody User u) {
		try {
			User cu = user_svc.saveUserAPI(u);
			return new ResponseEntity<User>(cu, HttpStatus.CREATED);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		try {
			user_svc.deleteUser(id);
			return new ResponseEntity<String>("** User deleted **", HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}





















