package com.s3_g2.microone.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	
	private String username;
	private String city;
	private Integer age;
}
