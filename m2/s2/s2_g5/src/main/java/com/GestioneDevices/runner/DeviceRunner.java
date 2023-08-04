package com.GestioneDevices.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;
import com.GestioneDevices.service.DeviceService;

@Component
public class DeviceRunner implements CommandLineRunner {
	
	@Autowired DeviceService svc;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("** ..Device Runner.. **");
		svc.saveDevice(svc.createNewLaptop("Lenovo R7", EDeviceType.LAPTOP, EDeviceState.AVAILABLE, "SSD 500 GB", "8GB", "Windows 11"));
		svc.saveDevice(svc.createNewTablet("Microsoft Surface", EDeviceType.TABLET, EDeviceState.AVAILABLE, 9.2, true));
		svc.saveDevice(svc.createNewSmartphone("iPhone SE 2020", EDeviceType.SMARTPHONE, EDeviceState.AVAILABLE, 4.7, "64GB", "12MB", "iOS 16"));
	}
}
