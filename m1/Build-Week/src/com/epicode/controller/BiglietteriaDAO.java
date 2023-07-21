package com.epicode.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.epicode.model.Biglietteria;
import com.epicode.model.Colors;
import com.epicode.model.DistributoreAutomatico;
import com.epicode.model.Mezzo;
import com.epicode.model.RivenditoreAutorizzato;
import com.epicode.model.TitoloDiViaggio;

public class BiglietteriaDAO {
	
	public static void save(Biglietteria b) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		System.out.println(Colors.ANSI_LIME_GREEN + "** Biglietteria inserita nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}
	}
	
	public static List<Biglietteria> getAllBiglietteria() {
		
		List<Biglietteria> ls = new ArrayList<Biglietteria>();
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		
		try {
		Query q = em.createNamedQuery("biglietteria.getAll");
		ls = q.getResultList();
		return ls;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
	}
	
	public static Biglietteria getById(long id) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Biglietteria b = new Biglietteria();
		try {
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT b FROM Biglietteria b WHERE b.id = :id");
		q.setParameter("id", id);
		return (Biglietteria) q.getSingleResult();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
	}
	
	public static RivenditoreAutorizzato getByName(String name) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		RivenditoreAutorizzato b = new RivenditoreAutorizzato();
		try {
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT b FROM RivenditoreAutorizzato b WHERE LOWER(b.nome) LIKE LOWER(:name)");
		q.setParameter("name", name);
		return (RivenditoreAutorizzato) q.getSingleResult();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
	}
	
	public static DistributoreAutomatico getByCodName(String codName) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		DistributoreAutomatico b = new DistributoreAutomatico();
		try {
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT b FROM DistributoreAutomatico b WHERE LOWER(b.codice) LIKE LOWER(:codName)");
		q.setParameter("codName", codName);
		return (DistributoreAutomatico) q.getSingleResult();
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + "Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}
	}
	
	public static void getTitoliEmessi(Biglietteria b) {
		
		boolean isDist = b instanceof DistributoreAutomatico ? true : false;
		if (isDist) {
			DistributoreAutomatico d = (DistributoreAutomatico) b;
			System.out.println("Il distributore " + d.getCodice() + " ha venduto" + Colors.ANSI_CYAN + " > " + d.getTitoliVenduti().size() + " < " + Colors.RESET + Colors.BOLD + "biglietti / abbonamenti.");
		} else {
			RivenditoreAutorizzato r = (RivenditoreAutorizzato) b;
			System.out.println("Il rivenditore " + r.getNome() + " ha venduto" + Colors.ANSI_CYAN + " > " +  r.getTitoliVenduti().size() + " < " +  Colors.RESET + Colors.BOLD +  "biglietti / abbonamenti.");
		}
		
	}
	
	public static List<TitoloDiViaggio> trovaAbbonamentiPerPeriodo(LocalDate data1, LocalDate data2) {
        EntityManager em = JpaUtil.getEMF().createEntityManager();
        try {
        String jpql = "SELECT b FROM TitoloDiViaggio b WHERE b.dataDiEmissione BETWEEN :data1 AND :data2";
        TypedQuery<TitoloDiViaggio> query = em.createQuery(jpql, TitoloDiViaggio.class);
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







