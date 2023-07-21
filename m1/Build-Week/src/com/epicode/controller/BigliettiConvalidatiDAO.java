package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.epicode.model.BigliettiConvalidati;
import com.epicode.model.Biglietto;
import com.epicode.model.Colors;
import com.epicode.model.Manutenzione;

public class BigliettiConvalidatiDAO {

	public static void save(BigliettiConvalidati m, Biglietto b){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
			b.setVidimato(true);
			em.getTransaction().begin();
			em.persist(m);		
			em.merge(b);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Biglietto convalidato e salvato nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}
	}
	
	public static BigliettiConvalidati getById(long id) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
		BigliettiConvalidati bc = new BigliettiConvalidati();
		em.getTransaction().begin();
		bc = em.find(BigliettiConvalidati.class, id);
		em.getTransaction().commit();
		return bc;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}

	}
	
	public static List<BigliettiConvalidati> convalidatiSuMezzo(long idMezzo) {
        EntityManager em = JpaUtil.getEMF().createEntityManager();
        
        try {
	        String jpql = "SELECT b FROM BigliettiConvalidati b WHERE b.mezzo.id = :idMezzo";
	        TypedQuery<BigliettiConvalidati> query = em.createQuery(jpql, BigliettiConvalidati.class);
	        query.setParameter("idMezzo", idMezzo);
	        return query.getResultList();
        } catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
    }
	
	public static List<BigliettiConvalidati> convalidatiPerData(LocalDate data1, LocalDate data2) {
        EntityManager em = JpaUtil.getEMF().createEntityManager();        
        try {
	        String jpql = "SELECT b FROM BigliettiConvalidati b WHERE b.data BETWEEN :data1 AND :data2";
	        TypedQuery<BigliettiConvalidati> query = em.createQuery(jpql, BigliettiConvalidati.class);
	        query.setParameter("data1", data1);
	        query.setParameter("data2", data2);
	        return query.getResultList();
        } catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
    }
	
	
	
	

}
