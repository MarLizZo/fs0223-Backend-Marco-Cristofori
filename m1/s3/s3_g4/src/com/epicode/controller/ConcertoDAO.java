package com.epicode.controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.model.Concerto;

public class ConcertoDAO {
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("test_jpa_2");
	public static EntityManager em = emf.createEntityManager();
	
	public static void save(Concerto e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("** Concerto " + e.getTitolo() + " salvato **");
	}
	
	public static Concerto getById(Long id) throws SQLException {
		Concerto ev = null;
		em.getTransaction().begin();
		ev = em.find(Concerto.class, id);
		em.getTransaction().commit();
		return ev;
	}
	
	public static void delete(Concerto ev) throws SQLException {
		em.getTransaction().begin();
		em.remove(ev);
		em.getTransaction().commit();
		System.out.println("** Concerto " + ev.getTitolo() +  " eliminato **");
	}
	
	public static void deleteById(Long id) throws SQLException {
		Concerto ev = getById(id);
		
		if (ev != null) {
			String title = ev.getTitolo();
			em.getTransaction().begin();
			em.remove(ev);
			em.getTransaction().commit();
			System.out.println("** Concerto " + title +  " eliminato **");
		} else {
			System.out.println("** Nessun Concerto trovato con l'id inserito **");
		}
	}
	
	public static void refresh(Concerto ev) {
		em.getTransaction().begin();
		em.refresh(ev);
		em.getTransaction().commit();
		System.out.println("** Refresh done **");
	}
}
