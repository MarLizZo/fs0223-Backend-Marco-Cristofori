package com.epicode.ex_1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		Customer lizzo = new Customer(1, "LizZo", 2);
		Customer umberto = new Customer(2, "Umberto", 2);
		Customer emanuele = new Customer(3, "Emanuele", 1);
		Customer anonimo = new Customer(4, "Chi sei?", 1);
		Customer misterioso = new Customer(5, "Uomo misterioso", 2);
		
		Product book_1 = new Product(1, "The Expanse 9", "Books", 120.00);
		Product book_2 = new Product(2, "The Expanse 7", "Books", 114.00);
		Product book_3 = new Product(3, "The Lord of the rings", "Books", 98.00);
		Product book_4 = new Product(4, "Su un altro pianeta", "Books", 178.00);
		Product book_5 = new Product(5, "Inseguendo un raggio di luce", "Books", 79.00);
		Product book_6 = new Product(6, "La teoria del tutto", "Books", 60.00);
		
		Product monitor_1 = new Product(7, "Samsung 4K UHD", "Monitors", 499.00);
		Product ps5_1 = new Product(8, "PS5", "Console", 539.00);
		
		Product toy_1 = new Product(9, "Barbie", "Baby", 8.39);
		Product toy_2 = new Product(10, "Action Man", "Baby", 8.99);
		Product toy_3 = new Product(11, "Bear Peluche", "Baby", 6.99);
		
		Product boys_1 = new Product(12, "Motorcycle Helmet", "Boys", 59.69);
		Product boys_2 = new Product(13, "Football ball", "Boys", 13.19);
		
		
		List<Product> lizzoOrder = new ArrayList<Product>();
		lizzoOrder.add(book_1); lizzoOrder.add(ps5_1); lizzoOrder.add(boys_2);

		List<Product> umbertoOrder = new ArrayList<Product>();
		umbertoOrder.add(monitor_1); umbertoOrder.add(toy_1);

		List<Product> emanueleOrder = new ArrayList<Product>();
		emanueleOrder.add(monitor_1); emanueleOrder.add(boys_1);
		
		List<Product> misteriosoOrder = new ArrayList<Product>();
		misteriosoOrder.add(toy_2); misteriosoOrder.add(boys_2); misteriosoOrder.add(book_4);
		
		List<Product> anonimoOrder = new ArrayList<Product>();
		anonimoOrder.add(toy_3); anonimoOrder.add(book_2); anonimoOrder.add(book_5); anonimoOrder.add(book_6);
		
		List<Product> list = new ArrayList<Product>();
		list.add(book_1); list.add(book_2); list.add(book_3); 
		list.add(book_4); list.add(book_5); list.add(book_6); 
		list.add(monitor_1); list.add(ps5_1);
		list.add(toy_1); list.add(toy_2); list.add(toy_3);
		list.add(boys_1); list.add(boys_2);

		Order order_1 = new Order(1, "Delivered", LocalDate.of(2021, 2, 6), LocalDate.of(2021, 2, 11), lizzoOrder, lizzo);
		Order order_2 = new Order(2, "Delivered", LocalDate.of(2021, 2, 14), LocalDate.of(2021, 2, 21), umbertoOrder, umberto);
		Order order_3 = new Order(3, "Delivered", LocalDate.of(2022, 4, 24), LocalDate.of(2022, 4, 28), emanueleOrder, emanuele);
		Order order_4 = new Order(4, "Delivered", LocalDate.of(2023, 5, 7), LocalDate.of(2023, 5, 10), misteriosoOrder, misterioso);
		Order order_5 = new Order(5, "Delivered", LocalDate.of(2023, 2, 1), LocalDate.of(2023, 2, 6), anonimoOrder, anonimo);

		List<Order> listOrders = new ArrayList<Order>();
		listOrders.add(order_1); listOrders.add(order_2); listOrders.add(order_3); listOrders.add(order_4); listOrders.add(order_5);
		
		// Esercizio uno
		System.out.println("***** INIZIO EX 1 *****");
		Stream<Product> st_1 = list.stream();
		st_1.filter(el -> el.getCategory().equals("Books") && el.getPrice() > 100 ).forEach(el -> System.out.println(el.toString()));
		
		System.out.println();
		
		// Esercizio due
		System.out.println("***** INIZIO EX 2 *****");
		Stream<Order> stOrd = listOrders.stream();
		List<Product> prodOrd = new ArrayList<Product>();
		stOrd.forEach(el -> el.getProducts().forEach(p -> prodOrd.add(p)));
		prodOrd.stream().filter(el -> el.getCategory().equals("Baby")).forEach(el -> System.out.println(el));
		
		System.out.println();
		
		// Esercizio tre
		System.out.println("***** INIZIO EX 3 *****");
		Stream<Product> st_2 = list.stream();
		st_2.filter(el -> el.getCategory().equals("Boys")).map(el ->  {
			double sconto = (el.getPrice() * 10) / 100;
			el.setPrice(el.getPrice() - sconto);
			return el;
		}).forEach(el -> System.out.println(el));
		
		System.out.println();
		
		//Esercizio quattro
		System.out.println("***** INIZIO EX 4 *****");
		
		Stream<Order> orders = listOrders.stream();
		orders.filter(el -> el.getCustomer().getTier() == 2 && el.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) 
			&& el.getOrderDate().isBefore(LocalDate.of(2021, 4, 1)))
				.forEach(el -> el.getProducts()
						.forEach(p -> System.out.println(p.toString())));
	}
}


























