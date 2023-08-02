package com.GestionePrenotazioni.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.GestionePrenotazioni.Colors;
import com.GestionePrenotazioni.configs.UserConfig;
import com.GestionePrenotazioni.models.Reservation;
import com.GestionePrenotazioni.models.User;
import com.GestionePrenotazioni.repositories.UserPagination;
import com.GestionePrenotazioni.repositories.UserRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	@Autowired UserRepo repo;
	@Autowired UserPagination pageRepo;
	@Autowired @Qualifier("empty_user") private ObjectProvider<User> empty_user;
	@Autowired @Qualifier("fake_user") private ObjectProvider<User> fake_user;
	
	public User createEmptyUser() {
		return empty_user.getObject();
	}
	
	public User createFakeUser() {
		return fake_user.getObject();
	}
	
	public User createUser(String _username, String _name, String _lastname, String _email) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(UserConfig.class);
		User u = (User) appContext.getBean("user_no_res", _username, _name, _lastname, _email);
		appContext.close();
		return u;
	}
	
	public User createCompleteUser(String _username, String _name, String _lastname, String _email, List<Reservation> reservations) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(UserConfig.class);
		User u = (User) appContext.getBean("user_with_res", _username, _name, _lastname, _email, reservations);
		appContext.close();
		return u;
	}
	
	public void saveUser(User u) {
		if (getByUsername(u.getUsername()) == null && repo.findByEmail(u.getEmail()) == null) {
			repo.save(u);
			System.out.println("** User " + u.getUsername() + " saved correctly **");
		} else {
			System.out.println("** ERROR **");
		}
	}
	
	public User getById(Long id) {
		if (repo.existsById(id)) {
			return repo.findById(id).get();
		} else {
			throw new EntityNotFoundException("** No User found.. **");
		}
	}
	
	public User saveUserAPI(User u) {
		if (getByUsername(u.getUsername()) == null && repo.findByEmail(u.getEmail()) == null) {
			return repo.save(u);
		} else {
			return null;
		}
	}
	
	public void deleteUser(Long id) {
		User u = getById(id);
		repo.deleteById(u.getId());
	}
	
	public Page<User> getAll(Pageable page) {
		return pageRepo.findAll(page);
	}
	
	public User getByUsername(String username) {
		return repo.findByUsername(username);
	}
}



























