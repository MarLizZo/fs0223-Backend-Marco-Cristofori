package com.GestioneDevices.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.GestioneDevices.entity.User;

public interface UserPaginationRepo extends PagingAndSortingRepository<User, Long> {
	
	
	
}
