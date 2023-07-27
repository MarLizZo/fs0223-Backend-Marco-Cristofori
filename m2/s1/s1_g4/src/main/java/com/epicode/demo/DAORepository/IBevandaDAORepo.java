package com.epicode.demo.DAORepository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.demo.model.Bevanda;

public interface IBevandaDAORepo extends CrudRepository<Bevanda, Integer> {

}
