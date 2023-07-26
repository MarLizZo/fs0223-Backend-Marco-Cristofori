package com.epicode.demo.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.epicode.demo.services.MenuService;

@Component
@Order(4)
public class OrdineRunner implements CommandLineRunner {
	
	@Autowired private MenuService ms;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		ms.createOrder();
	}
}
