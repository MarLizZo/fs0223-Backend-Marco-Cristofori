package com.epicode.controller;

import java.sql.SQLException;

import javax.persistence.EntityManager;

import com.epicode.model.Colors;
import com.epicode.model.Tessera;

public class TesseraDAO {
	
	public static void save(Tessera t){
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			System.out.println(Colors.ANSI_LIME_GREEN + "** Tessera inserita nel Database **");
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
		} finally {
			em.close();			
		}	

	}
	
	public static Tessera getById(long id) {
		EntityManager em = JpaUtil.getEMF().createEntityManager();
		Tessera t = new Tessera ();
		
		try {
			em.getTransaction().begin();
			t = em.find(Tessera.class, id);
			em.getTransaction().commit();
			return t;
		} catch (Exception e) {
			em.getTransaction().rollback();
			System.out.println(Colors.ANSI_RED_DANGER + ">> Rollback eseguito " + e.getMessage());
			return null;
		} finally {
			em.close();			
		}

	}
}
