package com.SpringSec.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringSec.security.entity.ERole;
import com.SpringSec.security.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
