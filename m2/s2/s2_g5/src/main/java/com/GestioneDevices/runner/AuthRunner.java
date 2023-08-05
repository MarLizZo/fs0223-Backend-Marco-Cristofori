package com.GestioneDevices.runner;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.GestioneDevices.entity.Role;
import com.GestioneDevices.entity.User;
import com.GestioneDevices.enumerators.ERole;
import com.GestioneDevices.payload.RegisterDto;
import com.GestioneDevices.repository.RoleRepository;
import com.GestioneDevices.repository.UserRepository;
import com.GestioneDevices.service.AuthService;
import com.github.javafaker.Faker;


@Component
public class AuthRunner implements ApplicationRunner {
	
	@Autowired RoleRepository roleRepository;
	@Autowired UserRepository userRepository;
	@Autowired PasswordEncoder passwordEncoder;
	@Autowired AuthService authService;
	
	private Set<Role> adminRole;
	private Set<Role> moderatorRole;
	private Set<Role> userRole;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("** ..Users Runner.. **");
		// Da lanciare solo la prima volta
		setRoleDefault();
		
		// set admin
//		RegisterDto dto = new RegisterDto();
//		Role admin = new Role(); admin.setRoleName(ERole.ROLE_ADMIN);
//		User u = userRepository.findById(1l).get(); u.setRoles(Set.of(roleRepository.findById(1l).get()));
//		userRepository.save(u);
		
//		for (int i = 0; i < 20; i++) {
//			RegisterDto reg = new RegisterDto(Faker.instance().name().firstName(), Faker.instance().name().username(), 
//					Faker.instance().internet().emailAddress(), "qwerty");
//			authService.register(reg);
//		}
	}
	
	private void setRoleDefault() {
		Role admin = new Role();
		admin.setRoleName(ERole.ROLE_ADMIN);
		if (!roleRepository.existsById(1l))
			roleRepository.save(admin);
		
		Role user = new Role();
		user.setRoleName(ERole.ROLE_USER);
		if (!roleRepository.existsById(2l))
			roleRepository.save(user);
		
		Role moderator = new Role();
		moderator.setRoleName(ERole.ROLE_MODERATOR);
		if (!roleRepository.existsById(3l))
			roleRepository.save(moderator);
		
		adminRole = new HashSet<Role>();
		adminRole.add(admin);
		adminRole.add(moderator);
		adminRole.add(user);
		
		moderatorRole = new HashSet<Role>();
		moderatorRole.add(moderator);
		moderatorRole.add(user);
		
		userRole = new HashSet<Role>();
		userRole.add(user);
	}

}
