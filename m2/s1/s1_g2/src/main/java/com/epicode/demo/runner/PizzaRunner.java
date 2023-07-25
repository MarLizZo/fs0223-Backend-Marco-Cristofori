package com.epicode.demo.runner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.ConfigurationClass;
import com.epicode.enumerators.Toppings;
import com.epicode.model.Pizza;
import com.epicode.model.Topping;

@Component
@Order(1)
public class PizzaRunner implements CommandLineRunner {
	
	public void configBeansPizza(String name, List<Topping> lsT, boolean isFamSize) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Pizza p1 = (Pizza) appContext.getBean("instancePizza", name, lsT, isFamSize);
		System.out.println(p1.getName() + "  **  Prezzo: " + p1.getPrezzo() + "  **  Calorie: " + p1.getCalories());
		
		appContext.close();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		
		configBeansPizza("Pizza Margherita", null, false);
		List<Topping> ls = new ArrayList<Topping>();
		ls.add(new Topping(Toppings.HAM)); ls.add(new Topping(Toppings.PINEAPPLE));
		configBeansPizza("Pizza Hawaiiana", ls, false);
		ls.clear();
		ls.add(new Topping(Toppings.SALAMI));
		configBeansPizza("Pizza Diavola", ls, false);
		ls.clear();
		System.out.println("Family Size for Pizza  **  Calories: x1.95  **  Prezzo: + 4.15");
	}
}
