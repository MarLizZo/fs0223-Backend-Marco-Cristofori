package com.epicode.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.epicode.enumerators.Toppings;
import com.epicode.model.Bevanda;
import com.epicode.model.Pizza;
import com.epicode.model.Topping;

@SpringBootApplication
public class FirstSbApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstSbApplication.class, args);
		System.out.println("** Benvenuto da Godfather's Pizza! **");
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
		
		System.out.println();
		
		configBeansTopping(Toppings.CHEESE);
		configBeansTopping(Toppings.HAM);
		configBeansTopping(Toppings.ONIONS);
		configBeansTopping(Toppings.PINEAPPLE);
		configBeansTopping(Toppings.SALAMI);
		
		System.out.println();
		
		configBeansDrink("Lemonade (0.33l)", 128, 1.29);
		configBeansDrink("Water (0.5l)", 0, 1.29);
		configBeansDrink("Wine (0.75l, 13%)", 607, 7.49);
		
	}
	
	public static void configBeansPizza(String name, List<Topping> lsT, boolean isFamSize) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Pizza p1 = (Pizza) appContext.getBean("instancePizza", name, lsT, isFamSize);
		System.out.println(p1.getName() + "  **  Prezzo: " + p1.getPrezzo() + "  **  Calorie: " + p1.getCalories());
		
		appContext.close();
	}
	
	public static void configBeansDrink(String name, double cal, double price) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Bevanda b1 = (Bevanda) appContext.getBean("instanceDrink", name, cal, price);
		System.out.println(b1.getName() + "  **  Prezzo : " + b1.getPrezzo() + "  **  Calorie: " + b1.getCalories());
		
		appContext.close();
	}
	
	public static void configBeansTopping(Toppings topp) {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(ConfigurationClass.class);
		
		Topping t1 = (Topping) appContext.getBean("instanceTopping", topp);
		System.out.println(t1.getName() + "  **  Prezzo: " + t1.getPrice() + "  **  Calorie: " + t1.getCalories());
		
		appContext.close();
	}
}



























