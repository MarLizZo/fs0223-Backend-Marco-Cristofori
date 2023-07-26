package com.epicode.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.epicode.enumerators.StatoOrdine;
import com.epicode.enumerators.Toppings;
import com.epicode.model.Bevanda;
import com.epicode.model.IProdotto;
import com.epicode.model.Ordine;
import com.epicode.model.Pizza;
import com.epicode.model.Tavolo;
import com.epicode.model.Topping;

@Configuration
public class ConfigurationClass {
	
	@Bean
	@Scope("prototype") 
	public Pizza instancePizza(String name, List<Topping> topps, boolean famSize) {
		return new Pizza(name, topps, famSize);
	}
	
	@Bean
	@Scope("prototype") 
	public Topping instanceTopping(Toppings topp) {
		return new Topping(topp);
	}
	
	@Bean
	@Scope("prototype") 
	public Bevanda instanceDrink(String name, double calories, double prezzo) {
		return new Bevanda(name, calories, prezzo);
	}
	
	@Bean("customDrink")
	@Scope("prototype") 
	public Bevanda instanceCustomDrink() {
		return new Bevanda();
	}
	
	@Bean
	@Scope("prototype") 
	public Ordine instanceOrder(long numeroOrdine, StatoOrdine statoOrdine, List<IProdotto> listaProdotti, LocalDate dataAcquisizione,
			int numeroCoperti, Tavolo tavolo) {
		return new Ordine(numeroOrdine, statoOrdine, listaProdotti, dataAcquisizione, numeroCoperti, tavolo);
	}
}




























