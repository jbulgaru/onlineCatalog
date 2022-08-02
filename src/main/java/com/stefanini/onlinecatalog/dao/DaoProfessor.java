package com.stefanini.onlinecatalog.dao;

import com.stefanini.onlinecatalog.JpaServiceW;
import com.stefanini.onlinecatalog.entity.Professors;
import com.stefanini.onlinecatalog.entity.Students;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class DaoProfessor implements DAO<Professors> {
    private static final JpaServiceW jpaServiceW = JpaServiceW.getInstance();
    private final EntityManagerFactory entityManagerFactory = jpaServiceW.getEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void save(Professors professor) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            boolean successfulPersist = false;
            transaction.begin();
            try {
                entityManager.persist(professor);
                successfulPersist = true;

            } finally {
                if (successfulPersist) transaction.commit();
                else transaction.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional get(Integer id) {
        return Optional.ofNullable(entityManager.find(Professors.class, id));
    }

    @Override
    public List<Professors> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM Professors c", Professors.class);
        return query.getResultList();
    }

    public List<Professors> getAllFiltered(String q) {
        Query query = entityManager.createQuery(
                        "SELECT p FROM Professors p WHERE lower(CONCAT(p.firstName, p.lastName)) LIKE ?1", Professors.class)
                .setParameter(1, '%' + q.toLowerCase() + '%');
        return query.getResultList();
    }


    public void update(Professors p) {
        executeInsideTransaction(entityManager -> entityManager.merge(p));
    }

    @Override
    public void delete(Professors p) {
        Professors persistentInstance = entityManager.merge(p);
        executeInsideTransaction(entityManager -> entityManager.remove(persistentInstance));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            System.out.println(e.getMessage());
        }
    }
    public Professors find(Integer id){
        Professors p =  entityManager.find(Professors.class, id);
        return p;
    }
    public void closeEntityManager() {
        if (entityManager != null)
            entityManager.close();
    }
}
