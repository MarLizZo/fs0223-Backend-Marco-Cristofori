package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.epicode.model.Colors;
import com.epicode.model.Manutenzione;
import com.epicode.model.Mezzo;
import com.epicode.model.TitoloDiViaggio;

public class ManutenzioneDAO {
	
	public static void save(Manutenzione m){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Manutenzione salvata nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}
	}
	
	public static Manutenzione getById(long id) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Manutenzione m = new Manutenzione();
		try {
			em.getTransaction().begin();
			m = em.find(Manutenzione.class, id);
			em.getTransaction().commit();
			return m;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}

	}
	
	public static List<Manutenzione> trovaManutenzionePerPeriodo(LocalDate data1, LocalDate data2) {
        EntityManager em = JpaUtil.getEMF().createEntityManager();
        try {
	        String jpql = "SELECT b FROM Manutenzione b WHERE b.dataInizio > :data1 AND b.dataFine < :data2";
	        TypedQuery<Manutenzione> query = em.createQuery(jpql, Manutenzione.class);
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
