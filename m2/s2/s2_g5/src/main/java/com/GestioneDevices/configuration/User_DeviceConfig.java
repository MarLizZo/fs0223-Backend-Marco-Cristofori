package com.GestioneDevices.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestioneDevices.entity.Device;
import com.GestioneDevices.entity.User;
import com.GestioneDevices.entity.User_Device;

@Configuration
public class User_DeviceConfig {

	@Bean
	@Scope("prototype")
	public User_Device createRelation(User user, Device device) {
		return new User_Device(user, device);
	}
}
