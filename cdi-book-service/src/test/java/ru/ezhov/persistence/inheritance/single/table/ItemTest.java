package ru.ezhov.persistence.inheritance.single.table;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Ignore
public class ItemTest {
    private static final Logger LOG = LoggerFactory.getLogger(ItemTest.class.getName());

    @Test
    public void selectAll() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Item item= new Item("yo");
            entityManager.persist(item);

            CD cd = new CD("12", "hello");
            entityManager.persist(cd);

            Book book = new Book("asdfsd","author" );
            entityManager.persist(book);

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}