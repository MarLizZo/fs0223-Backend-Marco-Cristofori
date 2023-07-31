package com.SpringWeb1.Repos;

import org.springframework.data.repository.CrudRepository;

import com.SpringWeb1.models.User;

public interface UserRepo extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
	
}
