package com.GestioneDevices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.GestioneDevices.entity.Device;
import com.GestioneDevices.entity.User;
import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.exception.MyAPIException;
import com.GestioneDevices.repository.DeviceRepo;
import com.GestioneDevices.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired UserRepository repo;
	@Autowired DeviceRepo device_repo;
	
	public String assignDeviceToUser(User u, Device d) {
		if (repo.existsById(u.getId()) && device_repo.existsById(d.getId())) {
			if (d.getState().equals(EDeviceState.AVAILABLE)) {
				User match = repo.findById(u.getId()).get();
				match.getDevices().add(d);
				repo.save(u);
				return "** Device " + d.getName() + " assigned to " + u.getUsername() + " **";
			} else {
				throw new MyAPIException(HttpStatus.BAD_REQUEST, "** The Device is not available **");
			}
		} else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "** User or Device does not exists **");
		}
	}
	
	
}
