package com.epicode.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.transaction.RollbackException;

import com.epicode.models.Book;
import com.epicode.models.ElementoBiblioteca;
import com.epicode.models.Magazine;

public class ElementoDAO {
	
	public static void saveElement(ElementoBiblioteca e) throws IllegalStateException, RollbackException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		String tipo = e instanceof Book ? "Libro " : e instanceof Magazine ? "Magazine " : "Elemento ";
		
		try {
			em.getTransaction().begin();
			em.persist(e);
			em.getTransaction().commit();
			System.out.println("** " + tipo + e.getTitle() + " salvato **");
		} finally {
			em.close();
		}
	}
	
	public static void removeElement(ElementoBiblioteca e) throws IllegalStateException, RollbackException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		String tipo = e instanceof Book ? "Libro " : e instanceof Magazine ? "Magazine " : "Elemento ";
		
		try {
			em.getTransaction().begin();
			em.remove(e);
			em.getTransaction().commit();
			System.out.println("** " + tipo + e.getTitle() + " eliminato **");
		} finally {
			em.close();
		}
	}
	
	public static List<ElementoBiblioteca> getAllElements() {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<ElementoBiblioteca> ls = null;
		
		try {
			Query q = em.createNamedQuery("ElementoBiblioteca.getAll");
			ls = q.getResultList();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} finally {
			em.close();
		}
		return ls;
	}
	
	public static List<Book> getAllBooks() {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<Book> ls = null;
		
		try {
			Query q = em.createNamedQuery("Book.getAll");
			ls = q.getResultList();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} finally {
			em.close();
		}
		return ls;
	}
	
	public static List<Magazine> getAllMagazine() {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<Magazine> ls = null;
		
		try {
			Query q = em.createNamedQuery("Magazine.getAll");
			ls = q.getResultList();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} finally {
			em.close();
		}
		return ls;
	}
	
	public static ElementoBiblioteca getElementByISBN(String isbn) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		ElementoBiblioteca element = new ElementoBiblioteca();
		
		try {
			Query q = em.createQuery("SELECT e FROM ElementoBiblioteca e WHERE e.ISBN LIKE :isbn_code");
			q.setParameter("isbn_code", isbn);
			element = (ElementoBiblioteca) q.getSingleResult();
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
		return element;
	}
	
	public static List<ElementoBiblioteca> getElementsByYear(int year) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<ElementoBiblioteca> ls = null;
		
		try {
			Query q = em.createQuery("SELECT e FROM ElementoBiblioteca e WHERE EXTRACT(YEAR FROM e.year) LIKE :year");
			q.setParameter("year", year);
			ls = q.getResultList();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} finally {
			em.close();
		}
		
		return ls;
	}
}





















