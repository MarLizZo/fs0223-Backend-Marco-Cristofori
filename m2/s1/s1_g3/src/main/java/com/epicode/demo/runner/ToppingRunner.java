package com.epicode.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.services.MenuService;
import com.epicode.enumerators.Toppings;

@Component
@Order(3)
public class ToppingRunner implements CommandLineRunner {
	
	@Autowired private MenuService ms;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		
		ms.createTopping(Toppings.CHEESE);
		ms.createTopping(Toppings.HAM);
		ms.createTopping(Toppings.ONIONS);
		ms.createTopping(Toppings.PINEAPPLE);
		ms.createTopping(Toppings.SALAMI);
	}
}
