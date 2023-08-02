package com.GestionePrenotazioni;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import com.GestionePrenotazioni.controller.APIController;
import com.GestionePrenotazioni.models.User;
import com.GestionePrenotazioni.repositories.UserRepo;
import com.GestionePrenotazioni.services.UserService;
import com.github.javafaker.Faker;


@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class UserTest {
	
	@Autowired TestRestTemplate restT;
	@Autowired UserRepo repo;
	@Autowired @Qualifier("empty_user") ObjectProvider<User> user;
	
	@Test
	@DisplayName("Post and Get by ID")
	void testPost() {
		User u = user.getObject();
		u.setUsername(Faker.instance().name().username()); u.setName("Test"); u.setLastname("User");
		u.setEmail(Faker.instance().internet().emailAddress()); u.setReservations(List.of());
		repo.save(u);
		System.out.println(u.getId());
		String url = "http://localhost:8080/api/user/" + u.getId();
		ResponseEntity<User> resp = restT.getForEntity(url, User.class);
		
		User u_res = resp.getBody();
		System.out.println(u_res.toString());
		HttpStatusCode status = resp.getStatusCode();
		
		assertThat(u_res.getId()).isEqualTo(u.getId());
		assertThat(status).isEqualTo(HttpStatus.OK);
		assertThat(u_res.getId()).isEqualTo(u.getId());
	}
}


























