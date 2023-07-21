package com.epicode.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.epicode.model.Colors;
import com.epicode.model.Tratta;
import com.epicode.model.Utente;

public class TrattaDAO {
	public static void save(Tratta m){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Tratta inserita nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}
	}
	
	public static Tratta getById(long id) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Tratta m = new Tratta();
		try {
			em.getTransaction().begin();
			m = em.find(Tratta.class, id);
			em.getTransaction().commit();
			return m;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
	}

	public static List<Tratta> getAll() {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		List<Tratta> ls = new ArrayList<Tratta>();
		try {
			String jpql = "SELECT t FROM Tratta t";
	        TypedQuery<Tratta> query = em.createQuery(jpql, Tratta.class);
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
