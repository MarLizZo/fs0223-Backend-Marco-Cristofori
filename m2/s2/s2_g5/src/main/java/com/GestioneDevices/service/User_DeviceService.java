package com.GestioneDevices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.GestioneDevices.configuration.User_DeviceConfig;
import com.GestioneDevices.entity.Device;
import com.GestioneDevices.entity.User;
import com.GestioneDevices.entity.User_Device;
import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.exception.MyAPIException;
import com.GestioneDevices.repository.DeviceRepo;
import com.GestioneDevices.repository.UserRepository;
import com.GestioneDevices.repository.Users_DevicesRepo;

@Service
public class User_DeviceService {
	
	@Autowired UserRepository user_repo;
	@Autowired DeviceRepo device_repo;
	@Autowired Users_DevicesRepo ud_repo;
	
	public User_Device createNewRelation(User u, Device d) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(User_DeviceConfig.class);
		User_Device ud = (User_Device) appContext.getBean("createRelation", u, d);
		appContext.close();
		return ud;
	}
	
	public String assignDeviceToUser(User u, Device d) {
		if (user_repo.existsById(u.getId()) && device_repo.existsById(d.getId())) {
			if (d.getState().equals(EDeviceState.AVAILABLE)) {
				
				User u_match = user_repo.findById(u.getId()).get();
				
				List<User_Device> ls = ud_repo.findByUserID(u.getId());
				
				// check if the user has never received a device OR if actually has no device
				if (ls.size() == 0 || ls.stream().allMatch(x -> x.getDataRestituzione() != null)) {
					Device dev_match = device_repo.findById(d.getId()).get();
					dev_match.setState(EDeviceState.ASSIGNED);
					
					ud_repo.save(createNewRelation(u_match, dev_match));
					device_repo.save(dev_match);
					return "** Device " + d.getName() + " assigned to " + u.getUsername() + " **";
				} else {
					throw new MyAPIException(HttpStatus.BAD_REQUEST, "** User " + u.getUsername() + " already have a device **");
				}
				
			} else {
				throw new MyAPIException(HttpStatus.BAD_REQUEST, "** The Device " + d.getName() + " is not available **");
			}
		} else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "** User or Device does not exists **");
		}
	}
}
