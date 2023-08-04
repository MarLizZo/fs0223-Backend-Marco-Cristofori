package com.GestioneDevices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GestioneDevices.entity.Role;
import com.GestioneDevices.enumerators.ERole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
