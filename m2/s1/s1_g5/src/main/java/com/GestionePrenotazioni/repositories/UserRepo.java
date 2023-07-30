package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GestionePrenotazioni.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}
