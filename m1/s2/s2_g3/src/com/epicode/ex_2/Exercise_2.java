package com.epicode.ex_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise_2 {
	
	public static int partialResult = 0;

	public static void main(String[] args) throws InterruptedException {
		Logger log = LoggerFactory.getLogger(Exercise_2.class);
		
	    List<String> arr = new ArrayList<String>();
	    Random rand = new Random();
	    
	    for (int i = 0; i < 3000; i++) {
	    	arr.add(Integer.toString(rand.nextInt(100)));
	    }
		
	    System.out.println(arr.size() + " elementi!");
	    
	    Thread_One t1 = new Thread_One(arr.subList(0, 999));
	    Thread_One t2 = new Thread_One(arr.subList(1000, 1999));
	    Thread_One t3 = new Thread_One(arr.subList(2000, 2999));
	    
	    t1.start();
	    t2.start();
	    t3.start();
	    t1.join();
	    t2.join();
	    t3.join();
	    
	    log.info("Somma di tutti i valori: " + Integer.toString(partialResult));
	}
}
























