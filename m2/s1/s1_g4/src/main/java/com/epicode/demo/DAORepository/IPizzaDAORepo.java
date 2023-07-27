package com.epicode.demo.DAORepository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.demo.model.Pizza;

public interface IPizzaDAORepo extends CrudRepository<Pizza, Integer> {
	
}
