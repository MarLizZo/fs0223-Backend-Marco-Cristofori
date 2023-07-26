package com.epicode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bevanda implements IProdotto {
	
	private String name;
	private double calories;
	private double prezzo;
	
}