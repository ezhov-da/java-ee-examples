package ru.ezhov.persistence.inheritance.table.per.clazz;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 30.10.2017.
 */
@Ignore
public class ItemTest {
    private static final Logger LOG = LoggerFactory.getLogger(ru.ezhov.persistence.inheritance.table.per.clazz.ItemTest.class.getName());

    @Test
    public void insert() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            ru.ezhov.persistence.inheritance.table.per.clazz.Item item =
                    new ru.ezhov.persistence.inheritance.table.per.clazz.Item("yo");
            entityManager.persist(item);

            ru.ezhov.persistence.inheritance.table.per.clazz.CD cd =
                    new ru.ezhov.persistence.inheritance.table.per.clazz.CD("12", "hello");
            entityManager.persist(cd);

            ru.ezhov.persistence.inheritance.table.per.clazz.Book book =
                    new ru.ezhov.persistence.inheritance.table.per.clazz.Book("asdfsd", "author");
            entityManager.persist(book);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

}