package com.epicode.model;

public class Bevanda implements IProdotto {
	private String name;
	private double calories;
	private double prezzo;
	
	public Bevanda(String _name, double _calories, double _prezzo) {
		this.name = _name;
		this.calories = _calories;
		this.prezzo = _prezzo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Bevanda [name=" + name + ", calories=" + calories + ", prezzo=" + prezzo + "]";
	}
}