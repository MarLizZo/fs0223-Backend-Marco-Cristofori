package com.epicode.demo.DAORepository;

import org.springframework.data.repository.CrudRepository;

import com.epicode.demo.model.Topping;

public interface IToppingRepo extends CrudRepository<Topping, Integer> {

}
