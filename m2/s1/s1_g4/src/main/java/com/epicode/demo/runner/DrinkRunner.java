package com.epicode.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.services.MenuService;
import com.epicode.demo.model.Bevanda;

@Component
@Order(2)
public class DrinkRunner implements CommandLineRunner {

	@Autowired private MenuService ms;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		
		Bevanda b1 = ms.createDrink("Lemonade (0.33l)", 128, 1.29);
		ms.saveDrink(b1);
		Bevanda b2 = ms.createDrink("Water (0.5l)", 0, 1.29);
		ms.saveDrink(b2);
		Bevanda b3 = ms.createDrink("Wine (0.75l, 13%)", 607, 7.49);
		ms.saveDrink(b3);
	}
}
