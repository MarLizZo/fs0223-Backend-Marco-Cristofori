package com.GestioneDevices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.GestioneDevices.entity.Device;
import com.GestioneDevices.entity.User;
import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.exception.MyAPIException;
import com.GestioneDevices.repository.DeviceRepo;
import com.GestioneDevices.repository.UserPaginationRepo;
import com.GestioneDevices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository repo;
	@Autowired DeviceRepo device_repo;
	@Autowired UserPaginationRepo pag_repo;
	
	public User getById(Long id) {
		if (repo.existsById(id))
			return repo.findById(id).get();
		else
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "** User not found **");
	}
	
	public Page<User> getUsersPagination(Pageable page) {
		return pag_repo.findAll(page);
	}
	
	public void deleteById(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		} else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "** User not found **");
		}
	}
}
