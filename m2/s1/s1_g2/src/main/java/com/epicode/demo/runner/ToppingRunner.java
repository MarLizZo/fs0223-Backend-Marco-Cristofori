package com.epicode.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.ConfigurationClass;
import com.epicode.enumerators.Toppings;
import com.epicode.model.Topping;

@Component
@Order(3)
public class ToppingRunner implements CommandLineRunner {
	
	public void configBeansTopping(Toppings topp) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Topping t1 = (Topping) appContext.getBean("instanceTopping", topp);
		System.out.println(t1.getName() + "  **  Prezzo: " + t1.getPrice() + "  **  Calorie: " + t1.getCalories());
		
		appContext.close();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		
		configBeansTopping(Toppings.CHEESE);
		configBeansTopping(Toppings.HAM);
		configBeansTopping(Toppings.ONIONS);
		configBeansTopping(Toppings.PINEAPPLE);
		configBeansTopping(Toppings.SALAMI);
	}
}
