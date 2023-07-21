package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.epicode.model.Abbonamento;
import com.epicode.model.BigliettiConvalidati;
import com.epicode.model.Biglietto;
import com.epicode.model.Colors;
import com.epicode.model.Mezzo;
import com.epicode.model.TitoloDiViaggio;

public class TitoloDiViaggioDAO {
	
	public static void save(TitoloDiViaggio t) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Titolo di viaggio salvato nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public static List<TitoloDiViaggio>getTitoliVenduti () {
		
		List<TitoloDiViaggio> listaTitoli = new ArrayList<TitoloDiViaggio>();
		
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
			Query q = em.createNamedQuery("titoloDiViaggio.getAll");
	        listaTitoli = q.getResultList();        
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}	
		return listaTitoli;
	}
	
	public static TitoloDiViaggio getById(long id) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		TitoloDiViaggio t = new TitoloDiViaggio();
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT e FROM TitoloDiViaggio e WHERE e.id = :id");
			q.setParameter("id", id);
	        t = (TitoloDiViaggio) q.getSingleResult();
	        return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
	}
	
	public static Biglietto getBigliettoByCodice(String cod) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Biglietto b = new Biglietto();
		
		try {
			em.getTransaction().begin();
			Query q = em.createQuery("SELECT b FROM Biglietto b WHERE b.codice LIKE :codice");
			q.setParameter("codice", cod);
			b = (Biglietto) q.getSingleResult();
			return b;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
	}
	
	public static void update (Biglietto m){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.merge(m);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Biglietto aggiornato **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}	
	}
	
	public static void verificaAbbonamento (String numeroTessera) {
        EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			String jpql = "SELECT b FROM Abbonamento b WHERE b.tessera.codiceUtente LIKE :numeroT";
			TypedQuery<Abbonamento> q = em.createQuery(jpql, Abbonamento.class);
	        q.setParameter("numeroT", numeroTessera);
	        Abbonamento ab = q.getSingleResult();
	        
	        if (ab.getDataScadenza().isAfter(LocalDate.now())) {
	        	System.out.println(Colors.ANSI_LIME_GREEN + "Abbonamento valido fino al " + ab.getDataScadenza());
	        } else {
	        	System.out.println(Colors.ANSI_YELLOW + "Abbonamento scaduto il " + ab.getDataScadenza());
	        }
        
		} catch (NoResultException n){
			System.out.println(Colors.ANSI_RED_DANGER + "Nessun abbonamento associato alla tessera " + numeroTessera);
			em.getTransaction().rollback();
		}catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}	
    }

}
