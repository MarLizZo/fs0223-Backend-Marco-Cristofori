package com.s3_g2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/os")
public class GatewayController {
	private final String serviceTwoUrl = "http://localhost:8082/app/";
	
	@GetMapping("/get-string")
	public String getOsOne() {
		RestTemplate rt = new RestTemplate();
		return rt.getForEntity(serviceTwoUrl + "/data1", String.class).getBody();
	}
	
	@GetMapping("/get-people")
	public Object getOsTwo() {
		RestTemplate rt = new RestTemplate();
		return rt.getForObject(serviceTwoUrl + "/data2", Object.class);
	}
	
	@GetMapping("/get-people-json")
	public ResponseEntity<Object> getOsThree() {
		RestTemplate rt = new RestTemplate();
		Object res = rt.getForObject(serviceTwoUrl + "/data3", Object.class);
		return ResponseEntity.ok(res);
	}
}
