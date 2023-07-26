package com.epicode.demo.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

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

@Service
@PropertySource("classpath:application.properties")
public class MenuService {
	
	@Value("${costo.tavolo.coperto}") private String costoCoperto;
	@Autowired @Qualifier("customDrink") private ObjectProvider<Bevanda> customBevanda;
	
	public void createPizza(String name, List<Topping> lsT, boolean isFamSize) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Pizza p1 = (Pizza) appContext.getBean("instancePizza", name, lsT, isFamSize);
		System.out.println(p1.getName() + "  **  Prezzo: " + p1.getPrezzo() + "  **  Calorie: " + p1.getCalories());
		
		appContext.close();
	}
	
	public Bevanda createDrink(String name, double cal, double price) {
		Bevanda b = customBevanda.getObject();
		return b.builder().name(name).calories(cal).prezzo(price).build();
	}
	
	public void createTopping(Toppings topp) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Topping t1 = (Topping) appContext.getBean("instanceTopping", topp);
		System.out.println(t1.getName() + "  **  Prezzo: " + t1.getPrice() + "  **  Calorie: " + t1.getCalories());
		
		appContext.close();
	}
	
	public void createOrder() {
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
}

























