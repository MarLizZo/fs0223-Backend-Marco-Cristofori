package com.epicode.controller;

import javax.persistence.EntityManager;
import javax.transaction.RollbackException;

import com.epicode.models.Author;
import com.epicode.models.Utente;

public class PersonsDAO {
	
	public static void saveAuthor(Author a) throws IllegalStateException, RollbackException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public static void saveUser(Utente u) throws IllegalStateException, RollbackException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
	
	public static void deleteUser(Utente u) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println(">> ERROR << Rollback executed >> " + ex.getMessage());
		}
		finally {
			em.close();
		}
	}
}





















