package com.epicode.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.transaction.RollbackException;

import com.epicode.models.Author;
import com.epicode.models.Prestito;

public class PrestitoDAO {
	public static void savePrestito(Prestito p) throws IllegalStateException, RollbackException {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			System.out.println("** Prestito salvato **");
		} finally {
			em.close();
		}
	}
	
	public static Prestito getPrestitoById(int id) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		Prestito p = new Prestito();
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.id = :id");
			q.setParameter("id", Long.valueOf(id));
			p = (Prestito) q.getSingleResult();
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
		
		return p;
	}
	
	public static List<Prestito> getPrestitiInCorso() {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<Prestito> ls = new ArrayList<Prestito>();
		
		try {
			Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.restituzioneEffettiva IS NULL");
			ls = q.getResultList();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} finally {
			em.close();
		}
		
		return ls;
	}
	
	public static List<Prestito> getPrestitiScadutiNonRestituiti() {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<Prestito> ls = new ArrayList<Prestito>();
		
		try {
			Query q = em.createQuery("SELECT p FROM Prestito p WHERE p.restituzioneEffettiva IS NULL");
			ls = q.getResultList();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} finally {
			em.close();
		}
		
		return ls.stream().filter(el -> el.getDataRestituzionePrevista().isBefore(LocalDate.now())).collect(Collectors.toList());
	}
	
	public static List<Prestito> getPrestitiByCardNumber(int number) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<Prestito> ls = new ArrayList<Prestito>();
		
		try {
			Query q = em.createNamedQuery("Prestito.getAll");
			ls = q.getResultList();
		} catch (IllegalArgumentException ex) {
			System.out.println(">> ERRORE: " + ex.getMessage());
		} finally {
			em.close();
		}
		return ls.stream().filter(el -> el.getUser().getCardnumber() == number).collect(Collectors.toList());
	}
	
	public static List<Prestito> getPrestitiInCorsoByCardNumber(int number) {
		EntityManager em = JPAUtil.getEMF().createEntityManager();
		List<Prestito> ls = getPrestitiByCardNumber(number);
		
		return ls.stream().filter(el -> el.getRestituzioneEffettiva() == null).collect(Collectors.toList());
	}
}






















