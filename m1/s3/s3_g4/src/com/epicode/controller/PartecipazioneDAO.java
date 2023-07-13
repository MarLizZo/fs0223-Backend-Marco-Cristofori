package com.epicode.controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.epicode.model.Partecipazione;

public class PartecipazioneDAO {
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("test_jpa_2");
	public static EntityManager em = emf.createEntityManager();
	
	public static void save(Partecipazione e) throws SQLException {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("** Partecipazione salvata **");
	}
	
	public static Partecipazione getById(Long id) throws SQLException {
		Partecipazione ev = null;
		em.getTransaction().begin();
		ev = em.find(Partecipazione.class, id);
		em.getTransaction().commit();
		return ev;
	}
	
	public static void delete(Partecipazione ev) throws SQLException {
		em.getTransaction().begin();
		em.remove(ev);
		em.getTransaction().commit();
		System.out.println("** Partecipazione eliminata **");
	}
	
	public static void deleteById(Long id) throws SQLException {
		Partecipazione ev = getById(id);
		
		if (ev != null) {
			em.getTransaction().begin();
			em.remove(ev);
			em.getTransaction().commit();
			System.out.println("** Partecipazione eliminata **");
		} else {
			System.out.println("** Nessuna Partecipazione trovata con l'id inserito **");
		}
	}
	
	public static void refresh(Partecipazione ev) {
		em.getTransaction().begin();
		em.refresh(ev);
		em.getTransaction().commit();
		System.out.println("** Refresh done **");
	}
}
