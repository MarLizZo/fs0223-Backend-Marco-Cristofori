package com.epicode.ex_1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Thread_1 extends Thread {
	Logger log = LoggerFactory.getLogger(Thread_1.class);
	String message;
	
	public Thread_1(String _message) {
		super();
		this.message = _message;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			log.info(message);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}




















