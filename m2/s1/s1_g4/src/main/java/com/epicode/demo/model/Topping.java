package com.epicode.demo.model;

import com.epicode.demo.enumerators.Toppings;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "toppings")
public class Topping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Toppings name;
	private double calories;
	private double price;
	
	public Topping(Toppings _name) {
		this.name = _name;
		switch (name) {
			case TOMATO: {
				this.calories = 0;
				this.price = 0;
				break;
			}
			case CHEESE: {
				this.calories = 92;
				this.price = 0.69;
				break;
			}
			case HAM: {
				this.calories = 35;
				this.price = 0.99;
				break;
			}
			case ONIONS: {
				this.calories = 22;
				this.price = 0.69;
				break;
			}
			case PINEAPPLE: {
				this.calories = 24;
				this.price = 0.79;
				break;
			}
			case SALAMI: {
				this.calories = 86;
				this.price = 0.99;
				break;
			}
		}
	}
}


























