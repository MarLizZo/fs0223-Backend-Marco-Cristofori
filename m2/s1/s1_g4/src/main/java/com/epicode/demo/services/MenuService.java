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
import com.epicode.demo.DAORepository.IBevandaDAORepo;
import com.epicode.demo.DAORepository.IPizzaDAORepo;
import com.epicode.demo.DAORepository.IToppingRepo;
import com.epicode.demo.enumerators.StatoOrdine;
import com.epicode.demo.enumerators.StatoTavolo;
import com.epicode.demo.enumerators.Toppings;
import com.epicode.demo.model.Bevanda;
import com.epicode.demo.model.IProdotto;
import com.epicode.demo.model.Ordine;
import com.epicode.demo.model.Pizza;
import com.epicode.demo.model.Tavolo;
import com.epicode.demo.model.Topping;

//@PropertySource("classpath:application.properties")
@Service
public class MenuService {
	
	//@Value("${costo.tavolo.coperto}") private String costoCoperto;
	@Autowired @Qualifier("customDrink") private ObjectProvider<Bevanda> customBevanda;
	@Autowired IToppingRepo topRepo;
	@Autowired IBevandaDAORepo drinkRepo;
	@Autowired IPizzaDAORepo pizzaRepo;
	
	public Pizza createPizza(String name, List<Topping> lsT, boolean isFamSize) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		Pizza p1 = (Pizza) appContext.getBean("instancePizza", name, lsT, isFamSize);
		appContext.close();
		return p1;
	}
	
	public Bevanda createDrink(String name, double cal, double price) {
		Bevanda b = customBevanda.getObject();
		return b.builder().name(name).calories(cal).prezzo(price).build();
	}
	
	public Topping createTopping(Toppings topp) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		Topping t1 = (Topping) appContext.getBean("instanceTopping", topp);
		appContext.close();
		return t1;
	}
	
//	public void createOrder() {
//		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
//		List<IProdotto> ls = new ArrayList<IProdotto>();
//		List<Topping> lsT = new ArrayList<Topping>();
//		lsT.add(new Topping(Toppings.SALAMI));
//		ls.add(new Pizza("Pizza Margherita", null, false));
//		ls.add(new Pizza("Pizza Diavola", lsT, false));
//		ls.add(new Bevanda("Water (0.5l)", 0, 1.29));
//		Tavolo t = new Tavolo(1, StatoTavolo.OCCUPATO);
//		
//		Ordine o = new Ordine(1, StatoOrdine.SERVITO, ls, LocalDate.of(2023, 7, 25), 2, t);
//		o.setTotaleOrdine(o.getTotaleOrdine() + 3.0);
//		
//		System.out.println(o.toString());
//		
//		appContext.close();
//	}
	
	public void saveTopping(Topping t) {
		topRepo.save(t);
		System.out.println("** " + t.getName() + " salvato nel DB **");
	}
	
	public void saveDrink(Bevanda b) {
		drinkRepo.save(b);
		System.out.println("** " + b.getName() + " salvato nel DB **");
	}
	
	public void savePizza(Pizza p) {
		pizzaRepo.save(p);
		System.out.println("** " + p.getName() + " salvato nel DB **");
	}
}

























