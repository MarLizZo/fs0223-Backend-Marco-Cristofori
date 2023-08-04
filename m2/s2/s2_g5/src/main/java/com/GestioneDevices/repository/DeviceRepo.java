package com.GestioneDevices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestioneDevices.entity.Device;
import com.GestioneDevices.enumerators.EDeviceState;
import com.GestioneDevices.enumerators.EDeviceType;

public interface DeviceRepo extends JpaRepository<Device, Long> {
	
	Optional<Device> findByType(EDeviceType type);
	Optional<Device> findByState(EDeviceState state);
	
	List<Device> findAllByType(EDeviceType type);
	List<Device> findAllByState(EDeviceState state);
	
	Boolean existsByName(String name);
}
