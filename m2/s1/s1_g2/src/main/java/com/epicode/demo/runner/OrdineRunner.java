package com.epicode.demo.runner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.ConfigurationClass;
import com.epicode.enumerators.StatoOrdine;
import com.epicode.enumerators.StatoTavolo;
import com.epicode.enumerators.Toppings;
import com.epicode.model.Bevanda;
import com.epicode.model.IProdotto;
import com.epicode.model.Ordine;
import com.epicode.model.Pizza;
import com.epicode.model.Tavolo;
import com.epicode.model.Topping;

@Component
@Order(4)
@PropertySource("classpath:application.properties")
public class OrdineRunner implements CommandLineRunner {
	
	@Value("${costo.tavolo.coperto}") private String costoCoperto;
	
	public void configBeansOrdine() {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		List<IProdotto> ls = new ArrayList<IProdotto>();
		List<Topping> lsT = new ArrayList<Topping>();
		lsT.add(new Topping(Toppings.SALAMI));
		ls.add(new Pizza("Pizza Margherita", null, false));
		ls.add(new Pizza("Pizza Diavola", lsT, false));
		ls.add(new Bevanda("Water (0.5l)", 0, 1.29));
		Tavolo t = new Tavolo(1, StatoTavolo.OCCUPATO);
		
		Ordine o = new Ordine(1, StatoOrdine.SERVITO, ls, LocalDate.of(2023, 7, 25), 2, t);
		o.setTotaleOrdine(o.getTotaleOrdine() + Double.valueOf(costoCoperto).doubleValue());
		
		System.out.println(o.toString());
		
		appContext.close();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		configBeansOrdine();
	}
}
