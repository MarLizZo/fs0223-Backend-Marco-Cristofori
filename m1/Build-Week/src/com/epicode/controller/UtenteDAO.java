package com.epicode.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.epicode.model.Colors;
import com.epicode.model.Manutenzione;
import com.epicode.model.Utente;


public class UtenteDAO {
	
	public static void save(Utente u){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		System.out.println(Colors.ANSI_LIME_GREEN + "** Utente " + u.getNome() + " inserito nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static Utente getById(long id) {
		
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Utente u = new Utente();
		
		try {
			em.getTransaction().begin();
			u = em.find(Utente.class, id);
			em.getTransaction().commit();				
			return u;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();
		}

	}
	
	public static void update (Utente u) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(u);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Utente aggiornato **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Rollback eseguito " + e.getMessage());
		} finally {
			em.close();
		}
	}

	public static List<Utente> getAll() {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		List<Utente> ls = new ArrayList<Utente>();
		try {
			String jpql = "SELECT u FROM Utente u";
	        TypedQuery<Utente> query = em.createQuery(jpql, Utente.class);
	        ls = query.getResultList();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println("Rollback eseguito " + e.getMessage());
		} finally {
			em.close();
		}
		return ls;
	}
}
