package com.epicode.model;

import com.epicode.enumerators.Toppings;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Topping {
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


























