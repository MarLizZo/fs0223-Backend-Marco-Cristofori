package com.epicode.controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.model.Persona;


public class PersonaDAO {
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("test_jpa_2");
	public static EntityManager em = emf.createEntityManager();
	
	public static void save(Persona e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("** Persona " + e.getNome() + " salvata **");
	}
	
	public static Persona getById(Long id) throws SQLException {
		Persona ev = null;
		em.getTransaction().begin();
		ev = em.find(Persona.class, id);
		em.getTransaction().commit();
		return ev;
	}
	
	public static void delete(Persona ev) throws SQLException {
		em.getTransaction().begin();
		em.remove(ev);
		em.getTransaction().commit();
		System.out.println("** Persona " + ev.getNome() +  " eliminata **");
	}
	
	public static void deleteById(Long id) throws SQLException {
		Persona ev = getById(id);
		
		if (ev != null) {
			String title = ev.getNome();
			em.getTransaction().begin();
			em.remove(ev);
			em.getTransaction().commit();
			System.out.println("** Persona " + title +  " eliminata **");
		} else {
			System.out.println("** Nessuna Persona trovato con l'id inserito **");
		}
	}
	
	public static void refresh(Persona ev) {
		em.getTransaction().begin();
		em.refresh(ev);
		em.getTransaction().commit();
		System.out.println("** Refresh done **");
	}
}
