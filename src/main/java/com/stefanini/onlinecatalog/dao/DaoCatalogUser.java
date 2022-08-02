package com.stefanini.onlinecatalog.dao;

import com.stefanini.onlinecatalog.JpaServiceW;
import com.stefanini.onlinecatalog.entity.CatalogUser;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class DaoCatalogUser implements DAO<CatalogUser> {
    private static final JpaServiceW jpaServiceW = JpaServiceW.getInstance();
    private final EntityManagerFactory entityManagerFactory = jpaServiceW.getEntityManagerFactory();
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void save(CatalogUser user) {
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            boolean successfulPersist = false;
            transaction.begin();
            try {
                entityManager.persist(user);
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
        return Optional.ofNullable(entityManager.find(CatalogUser.class, id));
    }

    public CatalogUser findByName(String username) {
        return entityManager.find(CatalogUser.class, username);
    }

    public Boolean checkCredentials(String username, String hash) {
        CatalogUser user = entityManager.createQuery(
                        "SELECT u FROM CatalogUser u WHERE u.username LIKE ?1", CatalogUser.class)
                .setParameter(1, username).getResultList().get(0);
        if (user != null) {
            return user.getPassword().equals(hash);
        }
        return false;
    }

    @Override
    public List<CatalogUser> getAll() {
        Query query = entityManager.createQuery("SELECT c FROM CatalogUser c", CatalogUser.class);
        return query.getResultList();
    }


    public void update(CatalogUser user) {
        executeInsideTransaction(entityManager -> entityManager.merge(user));
    }

    @Override
    public void delete(CatalogUser user) {
        CatalogUser persistentInstance = entityManager.merge(user);
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

    public void closeEntityManager() {
        if (entityManager != null)
            entityManager.close();
    }

    private String getHashPassword (String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }
}
