package com.GestionePrenotazioni.configs;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.GestionePrenotazioni.models.Reservation;
import com.GestionePrenotazioni.models.User;

@Configuration
public class UserConfig {
	
	@Bean("empty_user")
	@Scope("prototype")
	public User user() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")
	public User user_no_res(String _username, String _name, String _lastname, String _email) {
		User u = null;
		return u.builder().username(_username).name(_name).lastname(_lastname).email(_email).build();
	}
	
	@Bean
	@Scope("prototype")
	public User user_with_res(String _username, String _name, String _lastname, String _email, List<Reservation> reservations) {
		User u = null;
		return u.builder().username(_username).name(_name).lastname(_lastname).email(_email).reservations(reservations).build();
	}
}
