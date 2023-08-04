package com.GestioneDevices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.GestioneDevices.configuration.DeviceConfig;
import com.GestioneDevices.entity.Device;
import com.GestioneDevices.entity.Laptop;
import com.GestioneDevices.entity.Tablet;
import com.GestioneDevices.entity.Smartphone;
import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;
import com.GestioneDevices.repository.DeviceRepo;

@Service
public class DeviceService {

	@Autowired DeviceRepo repo;
	
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
			return null;
		}
	}
}
