package com.epicode.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.ConfigurationClass;
import com.epicode.model.Bevanda;

@Component
@Order(2)
public class DrinkRunner implements CommandLineRunner {

	public void configBeansDrink(String name, double cal, double price) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Bevanda b1 = (Bevanda) appContext.getBean("instanceDrink", name, cal, price);
		System.out.println(b1.getName() + "  **  Prezzo : " + b1.getPrezzo() + "  **  Calorie: " + b1.getCalories());
		
		appContext.close();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		
		configBeansDrink("Lemonade (0.33l)", 128, 1.29);
		configBeansDrink("Water (0.5l)", 0, 1.29);
		configBeansDrink("Wine (0.75l, 13%)", 607, 7.49);
	}
}
