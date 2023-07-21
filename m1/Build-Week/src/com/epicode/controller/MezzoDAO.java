package com.epicode.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.epicode.model.Colors;
import com.epicode.model.Mezzo;
import com.epicode.model.Tessera;
import com.epicode.model.Tratta;
import com.epicode.model.Utente;

public class MezzoDAO {
	
	public static void save(Mezzo m){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Mezzo inserito nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}
	}
	
	public static Mezzo getById(long id) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Mezzo m = new Mezzo();
		try {
			em.getTransaction().begin();
			m = em.find(Mezzo.class, id);
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
	
	public static void update (Mezzo m){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(m);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Mezzo aggiornato **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}
	}
	
	public static void percorriTratta(Tratta t, Mezzo m) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			boolean s = m.isInServizio();
			
			if (s) { 
				em.getTransaction().begin();
				int c = t.getContatore() + 1;		
				t.setContatore(c);
				em.merge(t);
				em.getTransaction().commit();
				System.out.println("Tratta " + t.getPartenza() + " - " + t.getCapolinea() + " percorsa in " + t.getTempoMedio() + " ore.");
			} else {
				System.out.println(Colors.ANSI_YELLOW + "** Mezzo attualmente fuori servizio, prova con un altro! **");
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
			
			
		} finally {
			em.close();			
		}
	}

	public static List<Mezzo> getAll() {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		List<Mezzo> ls = new ArrayList<Mezzo>();
		try {
			String jpql = "SELECT m FROM Mezzo m";
	        TypedQuery<Mezzo> query = em.createQuery(jpql, Mezzo.class);
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
