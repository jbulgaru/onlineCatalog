package com.stefanini.onlinecatalog;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaService {
    private final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("persistenceUnitName");
    public  EntityManager entityManager;
    private JpaService() {entityManager = entityManagerFactory.createEntityManager();}
    public static  EntityManager getInstance() {
        return new JpaService().entityManager;
    }
}
