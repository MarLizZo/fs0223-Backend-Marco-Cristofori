package com.epicode.ex_3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise_3 {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Exercise_3.class);
		RegistroPresenze reg = new RegistroPresenze();
		
		try {
			reg.salvaPresenza("Marco", 7);
			reg.salvaPresenza("Umberto", 1);
			reg.salvaPresenza("Emanuele", 9);
		} catch (IOException ex) {
			log.error("Errore nella scrittura del file! " + ex);
		}
		
		try {
			Map<String, String> data = new HashMap<String, String>();
			data = reg.leggiPresenze();
			data.forEach((key, value) -> {
				System.out.println("Nome: " + key + " # Presenze: " + value);
			});
		} catch (IOException ex) {
			log.error("Errore nel caricamento del file! " + ex);
		}
	}
}
