package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;

import com.GestionePrenotazioni.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	public User findByUsername(String username);
	public User findByEmail(String email);
}
