package com.epicode.model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import com.epicode.enumerators.Toppings;

import lombok.Setter;

@Setter
public class Pizza implements IProdotto {
	private String name;
	private Double prezzo;
	private Double calories;
	private List<Topping> toppings = new ArrayList<Topping>();
	private boolean familySize;
	
	public Pizza(String _name, List<Topping> _toppings, boolean _familySize) {
		this.name = _name;
		this.familySize = _familySize;
		this.prezzo = 4.99;
		this.calories = 1104.0;
		this.toppings.add(new Topping(Toppings.TOMATO));
		this.toppings.add(new Topping(Toppings.CHEESE));
		
		if (_toppings != null) {
			_toppings.forEach(t -> { 
				this.toppings.add(t);
				this.prezzo += t.getPrice();
				this.calories += t.getCalories();
			});
		}
		
		if (this.familySize) {
			this.calories = this.calories * 1.95;
			this.prezzo += 4.15;
		}
	}

	public String getName() {
		return name;
	}

	public Double getPrezzo() {
		return BigDecimal.valueOf(prezzo).setScale(3, RoundingMode.HALF_EVEN).doubleValue();
	}

	public Double getCalories() {
		return BigDecimal.valueOf(calories).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

	public List<Topping> getToppings() {
		return this.toppings;
	}

	public boolean isFamilySize() {
		return familySize;
	}

	@Override
	public String toString() {
		return "Pizza [name=" + name + ", prezzo=" + prezzo + ", calories=" + calories + ", toppings=" + getToppings()
				+ ", familySize=" + familySize + "]";
	}
}

























