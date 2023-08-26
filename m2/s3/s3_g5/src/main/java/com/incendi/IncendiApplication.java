package com.incendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.incendi.models.Edificio;
import com.incendi.models.Sonda;
import com.incendi.observers.ObserverSonda;

@SpringBootApplication
@SuppressWarnings("deprecation")
public class IncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncendiApplication.class, args);
		ObserverSonda obs = new ObserverSonda();
		Edificio e1 = Edificio.builder().name("Casa di legno").city("Viterbo").address("Via XXIII Settembre")
				.latitude("00.00").longitude("00.01").build();
		Sonda s1 = Sonda.builder().name("Safe Sonda").livelloFumo(0).edificio(e1).build();
		s1.addObserver(obs);
		s1.setLivelloFumo(4);
	}
}
