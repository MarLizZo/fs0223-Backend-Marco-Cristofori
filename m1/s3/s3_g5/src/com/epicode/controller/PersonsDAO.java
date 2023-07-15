package com.epicode.controller;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.transaction.RollbackException;

import com.epicode.models.Author;
import com.epicode.models.ElementoBiblioteca;
import com.epicode.models.Utente;

public class PersonsDAO {
	
	public static void saveAuthor(Author a) throws IllegalStateException, RollbackException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
			System.out.println("** Autore " + a.getName() + " salvato **");
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
			System.out.println("** Utente " + u.getName() + " salvato **");
		} finally {
			em.close();
		}
	}
	
	public static void deleteAuthor(Author a) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			System.out.println("** Autore " + a.getName() + " eliminato **");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println(">> ERROR << Rollback executed >> " + ex.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public static void deleteUser(Utente u) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.remove(u);
			em.getTransaction().commit();
			System.out.println("** Utente " + u.getName() + " eliminato **");
		} catch (Exception ex) {
			em.getTransaction().rollback();
			System.out.println(">> ERROR << Rollback executed >> " + ex.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public static Author getAuthor(int id) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Author a = new Author();
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT a FROM Author a WHERE a.id = :id");
			q.setParameter("id", id);
			a = (Author) q.getSingleResult();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} catch (NoResultException ex) {
			System.out.println(">> ERRORE - Nessun risultato >> " + ex.getMessage());
		} catch (NonUniqueResultException ex) {
			System.out.println(">> ERRORE - Piu di un risultato >> " + ex.getMessage());
		}
		finally {
			em.close();
		}
		return a;
	}
	
	public static Utente getUser(int id) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Utente u = new Utente();
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT u FROM Utente u WHERE u.id = :id");
			q.setParameter("id", Long.valueOf(id));
			u = (Utente) q.getSingleResult();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} catch (NoResultException ex) {
			System.out.println(">> ERRORE - Nessun risultato >> " + ex.getMessage());
		} catch (NonUniqueResultException ex) {
			System.out.println(">> ERRORE - Piu di un risultato >> " + ex.getMessage());
		}
		finally {
			em.close();
		}
		return u;
	}
}





















