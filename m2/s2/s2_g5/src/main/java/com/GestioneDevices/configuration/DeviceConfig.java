package com.GestioneDevices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestioneDevices.entity.Laptop;
import com.GestioneDevices.entity.Smartphone;
import com.GestioneDevices.entity.Tablet;
import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;

@Configuration
public class DeviceConfig {

	@Bean
	@Scope("prototype")
	public Laptop createLaptop(String name, EDeviceType type, EDeviceState state, String storage, String ram, String os) {
		return new Laptop(name, type, state, storage, ram, os);
	}
	
	@Bean
	@Scope("prototype")
	public Tablet createTablet(String name, EDeviceType type, EDeviceState state, Double inch, Boolean with_pen) {
		return new Tablet(name, type, state, inch, with_pen);
	}
	
	@Bean
	@Scope("prototype")
	public Smartphone createSmartphone(String name, EDeviceType type, EDeviceState state, Double inch, String storage, String camera, String os) {
		return new Smartphone(name, type, state, inch, storage, camera, os);
	}
}



















