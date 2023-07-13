package com.epicode.controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.model.Location;

public class LocationDAO {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("test_jpa_2");
	public static EntityManager em = emf.createEntityManager();
	
	public static void save(Location e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("** Location " + e.getNome() + " salvata **");
	}
	
	public static Location getById(Long id) throws SQLException {
		Location ev = null;
		em.getTransaction().begin();
		ev = em.find(Location.class, id);
		em.getTransaction().commit();
		return ev;
	}
	
	public static void delete(Location ev) throws SQLException {
		em.getTransaction().begin();
		em.remove(ev);
		em.getTransaction().commit();
		System.out.println("** Location " + ev.getNome() +  " eliminata **");
	}
	
	public static void deleteById(Long id) throws SQLException {
		Location ev = getById(id);
		
		if (ev != null) {
			String title = ev.getNome();
			em.getTransaction().begin();
			em.remove(ev);
			em.getTransaction().commit();
			System.out.println("** Location " + title +  " eliminata **");
		} else {
			System.out.println("** Nessuna Location trovato con l'id inserito **");
		}
	}
	
	public static void refresh(Location ev) {
		em.getTransaction().begin();
		em.refresh(ev);
		em.getTransaction().commit();
		System.out.println("** Refresh done **");
	}

}



























