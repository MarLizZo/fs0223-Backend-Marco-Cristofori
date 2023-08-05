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
		/*svc.saveDevice(svc.createNewLaptop("Lenovo R7", EDeviceType.LAPTOP, EDeviceState.AVAILABLE, "SSD 500 GB", "8GB", "Windows 11"));
		svc.saveDevice(svc.createNewTablet("Microsoft Surface", EDeviceType.TABLET, EDeviceState.AVAILABLE, 9.2, true));
		svc.saveDevice(svc.createNewSmartphone("iPhone SE 2020", EDeviceType.SMARTPHONE, EDeviceState.AVAILABLE, 4.7, "64GB", "12MB", "iOS 16"));
		
		svc.saveDevice(svc.createNewSmartphone("Galaxy S20", EDeviceType.SMARTPHONE, EDeviceState.AVAILABLE, 5.2, "128GB", "16MB", "Android"));
		svc.saveDevice(svc.createNewSmartphone("Galaxy S21", EDeviceType.SMARTPHONE, EDeviceState.AVAILABLE, 5.4, "128GB", "18MB", "Android"));
		svc.saveDevice(svc.createNewSmartphone("Galaxy J5", EDeviceType.SMARTPHONE, EDeviceState.AVAILABLE, 4.8, "64GB", "12MB", "Android"));
		svc.saveDevice(svc.createNewSmartphone("iPhone XR", EDeviceType.SMARTPHONE, EDeviceState.AVAILABLE, 5.0, "128GB", "15MB", "iOS 15"));
		svc.saveDevice(svc.createNewSmartphone("iPhone 14", EDeviceType.SMARTPHONE, EDeviceState.AVAILABLE, 5.6, "256GB", "22MB", "iOS 16"));
		
		svc.saveDevice(svc.createNewLaptop("Acer", EDeviceType.LAPTOP, EDeviceState.AVAILABLE, "SSD 500 GB", "16GB", "Windows 10"));
		svc.saveDevice(svc.createNewLaptop("Asus", EDeviceType.LAPTOP, EDeviceState.AVAILABLE, "SSD 256 GB", "12GB", "Linux Manjaro"));
		svc.saveDevice(svc.createNewLaptop("Mac", EDeviceType.LAPTOP, EDeviceState.AVAILABLE, "SSD 500 GB", "32GB", "MacOS"));
		svc.saveDevice(svc.createNewLaptop("Lenovo R5", EDeviceType.LAPTOP, EDeviceState.AVAILABLE, "SSD 256 GB", "8GB", "Windows 10"));
		
		svc.saveDevice(svc.createNewTablet("Galaxy Tab", EDeviceType.TABLET, EDeviceState.AVAILABLE, 8.8, false));
		svc.saveDevice(svc.createNewTablet("HUAWEI Matepad", EDeviceType.TABLET, EDeviceState.AVAILABLE, 8.2, true));
		svc.saveDevice(svc.createNewTablet("iPad", EDeviceType.TABLET, EDeviceState.AVAILABLE, 9.8, true));*/
	}
}
