package com.SpringWeb1.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.SpringWeb1.models.User;

@Configuration
public class UserConfig {
	
	@Bean("empty_user")
	@Scope("prototype")
	public User user() {
		return new User();
	}
	
	@Bean
	@Scope("prototype")
	public User createUser(String _username, String _name, String _lastname, Integer _age, String _description) {
		return User.builder().username(_username).name(_name).lastname(_lastname).age(_age).description(_description).build();
	}
}
