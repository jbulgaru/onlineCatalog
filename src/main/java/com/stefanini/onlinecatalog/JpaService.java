package com.stefanini.onlinecatalog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaService {
    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("persistenceUnitName");
    private static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    private JpaService() {}
    public static  EntityManager getInstance() {
        return entityManager;
    }
}
