package ru.ezhov.persistence.inheritance.joined;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ezhov.persistence.inheritance.single.table.*;
import ru.ezhov.persistence.inheritance.single.table.Book;
import ru.ezhov.persistence.inheritance.single.table.CD;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 30.10.2017.
 */
public class ItemTest {
    private static final Logger LOG = LoggerFactory.getLogger(ru.ezhov.persistence.inheritance.single.table.ItemTest.class.getName());

    @Test
    public void insert() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            ru.ezhov.persistence.inheritance.joined.Item  item=  new ru.ezhov.persistence.inheritance.joined.Item("yo");
            entityManager.persist(item);

            ru.ezhov.persistence.inheritance.joined.CD cd = new ru.ezhov.persistence.inheritance.joined.CD("12", "hello");
            entityManager.persist(cd);

            ru.ezhov.persistence.inheritance.joined.Book book = new ru.ezhov.persistence.inheritance.joined.Book("asdfsd", "author");
            entityManager.persist(book);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}