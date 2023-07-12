package com.epicode.controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.model.Evento;

public class EventDAO {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("test_jpa");
	public static EntityManager em = emf.createEntityManager();
	
	public static void save(Evento e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("** Evento " + e.getTitolo() + " salvato **");
	}
	
	public static Evento getById(Long id) throws SQLException {
		Evento ev = null;
		em.getTransaction().begin();
		ev = em.find(Evento.class, id);
		em.getTransaction().commit();
		return ev;
	}
	
	public static void delete(Evento ev) throws SQLException {
		em.getTransaction().begin();
		em.remove(ev);
		em.getTransaction().commit();
		System.out.println("** Evento " + ev.getTitolo() +  " eliminato **");
	}
	
	public static void deleteById(Long id) throws SQLException {
		Evento ev = getById(id);
		
		if (ev != null) {
			String title = ev.getTitolo();
			em.getTransaction().begin();
			em.remove(ev);
			em.getTransaction().commit();
			System.out.println("** Evento " + title +  " eliminato **");
		} else {
			System.out.println("** Nessun Evento trovato con l'id inserito **");
		}
	}
	
	public static void refresh(Evento ev) {
		em.getTransaction().begin();
		em.refresh(ev);
		em.getTransaction().commit();
		System.out.println("** Refresh done **");
	}

}

























