package com.GestionePrenotazioni.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.GestionePrenotazioni.models.User;

public interface UserPagination extends PagingAndSortingRepository<User, Long> {
	
}
