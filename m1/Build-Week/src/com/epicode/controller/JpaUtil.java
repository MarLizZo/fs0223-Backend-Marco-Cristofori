package com.epicode.controller;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("BWJava-1");
        } catch (Throwable ex) {
            System.err.println(">> EMF creation failed.. <<" + ex.getMessage());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEMF() {
        return entityManagerFactory;
    }

}
