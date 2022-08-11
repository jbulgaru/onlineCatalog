package com.stefanini.onlinecatalog.dao;

import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


public interface DAO<T> {

    Optional<T> get(Integer id);

    List<T> getAll() throws Exception;

    void save(T t);

    void update(T t);

    void delete(T t);

}
