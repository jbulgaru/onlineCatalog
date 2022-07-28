package com.stefanini.onlinecatalog;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaServiceW {
    private static JpaServiceW instance;
    private EntityManagerFactory entityManagerFactory;

    private JpaServiceW() {
        entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnitName");
    }

    public static synchronized JpaServiceW getInstance() {
        return instance == null ? instance = new JpaServiceW() : instance;
    }

    public void shutDown() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
