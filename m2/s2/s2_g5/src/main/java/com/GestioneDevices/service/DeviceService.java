package com.GestioneDevices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.GestioneDevices.configuration.DeviceConfig;
import com.GestioneDevices.entity.Device;
import com.GestioneDevices.entity.Laptop;
import com.GestioneDevices.entity.Tablet;
import com.GestioneDevices.entity.Smartphone;
import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;
import com.GestioneDevices.exception.MyAPIException;
import com.GestioneDevices.repository.DevicePaginationRepo;
import com.GestioneDevices.repository.DeviceRepo;

@Service
public class DeviceService {

	@Autowired DeviceRepo repo;
	@Autowired DevicePaginationRepo pag_repo;
	
	public Laptop createNewLaptop(String name, EDeviceType type, EDeviceState state, String storage, String ram, String os) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DeviceConfig.class);
		Laptop l = (Laptop) appContext.getBean("createLaptop", name, type, state, storage, ram, os);
		appContext.close();
		return l;
	}
	
	public Smartphone createNewSmartphone(String name, EDeviceType type, EDeviceState state, Double inch, String storage, String camera, String os) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DeviceConfig.class);
		Smartphone s = (Smartphone) appContext.getBean("createSmartphone", name, type, state, inch, storage, camera, os);
		appContext.close();
		return s;
	}
	
	public Tablet createNewTablet(String name, EDeviceType type, EDeviceState state, Double inch, Boolean with_pen) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(DeviceConfig.class);
		Tablet t = (Tablet) appContext.getBean("createTablet", name, type, state, inch, with_pen);
		appContext.close();
		return t;
	}
	
	public Device saveDevice(Device d) {
		if (!repo.existsByName(d.getName())) {
			return repo.save(d);
		} else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "** Device already exist **");
		}
	}
	
	public Device getById(Long id) {
		if (repo.existsById(id))
			return repo.findById(id).get();
		else
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "** Device not found **");
	}
	
	public Page<Device> getAllDevicePaginated(Pageable page) {
		return pag_repo.findAll(page);
	}
	
	public void deleteById(Long id) {
		if (repo.existsById(id)) {
			repo.deleteById(id);
		} else {
			throw new MyAPIException(HttpStatus.BAD_REQUEST, "** Device not found **");
		}
	}
}
