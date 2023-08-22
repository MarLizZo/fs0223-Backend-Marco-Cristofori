package com.s3_g2.microone.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s3_g2.microone.models.User;

@RestController
@RequestMapping("/app")
public class MicroOneController {
	
	@GetMapping("/data1")
	public String getResponseStr() {
		return "Response String working!";
	}

	@GetMapping("/data2")
	public ResponseEntity<List<User>> getResArrayList() {
		List<User> users = List.of(new User("LizZo", "VT", 28), new User("Gildo", "RM", 50), new User("Geltrude", "MI", 38));
		return ResponseEntity.ok(users);
	}

	@GetMapping("/data3")
	public List<User> getArrayList() {
		List<User> users = List.of(new User("LizZo", "VT", 28), new User("Gildo", "RM", 50), new User("Geltrude", "MI", 38));
		return users;
	}
}
