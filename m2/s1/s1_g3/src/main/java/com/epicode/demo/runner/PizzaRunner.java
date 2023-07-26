package com.epicode.demo.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.services.MenuService;
import com.epicode.enumerators.Toppings;
import com.epicode.model.Topping;

@Component
@Order(1)
public class PizzaRunner implements CommandLineRunner {
	
	@Autowired private MenuService ms;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		
		ms.createPizza("Pizza Margherita", null, false);
		List<Topping> ls = new ArrayList<Topping>();
		ls.add(new Topping(Toppings.HAM)); ls.add(new Topping(Toppings.PINEAPPLE));
		ms.createPizza("Pizza Hawaiiana", ls, false);
		ls.clear();
		ls.add(new Topping(Toppings.SALAMI));
		ms.createPizza("Pizza Diavola", ls, false);
		ls.clear();
		System.out.println("Family Size for Pizza  **  Calories: x1.95  **  Prezzo: + 4.15");
	}
}
