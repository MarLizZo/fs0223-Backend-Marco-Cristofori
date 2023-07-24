package com.epicode.model;

import com.epicode.enumerators.Toppings;

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

	public Toppings getName() {
		return name;
	}

	public void setName(Toppings name) {
		this.name = name;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Topping [name=" + name + ", calories=" + calories + ", price=" + price + "]";
	}
}


























