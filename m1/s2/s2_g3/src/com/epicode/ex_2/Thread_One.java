package com.epicode.ex_2;

import java.util.List;

public class Thread_One extends Thread {

	private List<String> arr;
	
	public Thread_One(List<String> objects) {
		super();
		this.arr = (List<String>) objects;
	}
	
	@Override
	public void run() {
		doOperation();
	}
	
	private synchronized void doOperation() {
		arr.forEach(element -> {
			Exercise_2.partialResult += Integer.parseInt(element);
		});
	}
}
