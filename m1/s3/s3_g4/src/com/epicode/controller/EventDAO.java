package com.epicode.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.epicode.enumerations.Genere;
import com.epicode.model.Concerto;
import com.epicode.model.Evento;

public class EventDAO {
	
	static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("test_jpa_2");
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
	
	public static void refresh(Evento ev) throws SQLException {
		em.getTransaction().begin();
		em.refresh(ev);
		em.getTransaction().commit();
		System.out.println("** Refresh done **");
	}
	
	public static List<Concerto> getConcertiInStreaming() throws SQLException {
		Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = true");
		return q.getResultList();
	}
	
	public static List<Concerto> getConcertiPerTipo(Genere tipo) throws SQLException {
		Query q = em.createQuery("SELECT c FROM Concerto c WHERE c.genere LIKE :tipo_c");
		q.setParameter("tipo_c", tipo);
		return q.getResultList();
	}

}

























