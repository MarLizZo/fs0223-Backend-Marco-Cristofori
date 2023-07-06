package com.epicode.ex_1;
import java.time.LocalDate;
import java.util.List;

public class Order {
	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliveryDate; 
	private List<Product> products;
	private Customer customer;
	
	public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
			Customer customer) {
		this.id = id;
		this.status = status;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.products = products;
		this.customer = customer;
	}
	
	public long getId() {
		return id;
	}
	public String getStatus() {
		return status;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public List<Product> getProducts() {
		return products;
	}
	public Customer getCustomer() {
		return customer;
	}
	
	@Override
	public String toString() {
		return "Order ID: " + id + " Status: " + status + " Customer ID: " + customer.getId() + " Order Date: " + orderDate;
	}
}
