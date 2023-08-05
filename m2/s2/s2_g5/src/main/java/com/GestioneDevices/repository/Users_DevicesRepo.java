package com.GestioneDevices.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.GestioneDevices.entity.User;
import com.GestioneDevices.entity.User_Device;

public interface Users_DevicesRepo extends JpaRepository<User_Device, Long> {
	
	public List<User_Device> findByDataAssegnazioneBetween(LocalDate from, LocalDate to);
	
	@Query("SELECT ud FROM User_Device ud JOIN ud.user u WHERE u.username = :username")
	public List<User_Device> findByUsername(String username);
	
	@Query("SELECT ud FROM User_Device ud JOIN ud.user u WHERE u.id = :id")
	public List<User_Device> findByUserID(Long id);
	
	@Query("SELECT ud.device FROM User_Device ud JOIN ud.device u WHERE u.state = 'ASSIGNED'")
	public List<User_Device> findByNonRestituiti();
}
