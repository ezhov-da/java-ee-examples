package ru.ezhov.persistence;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ezhov.persistence.note.NoteBig;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 28.10.2017.
 */
public class NoteBigTest {
    private static final Logger LOG = LoggerFactory.getLogger(NoteBigTest.class.getName());

    @Test
    public void selectAll() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            List<NoteBig> list = entityManager.createQuery(
                    "select n FROM NoteBig n",
                    NoteBig.class
            ).getResultList();

            LOG.info("list: {}", list);
            assertTrue(!list.isEmpty());
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    @Test
    public void addNew() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            NoteBig noteBig = new NoteBig(
                    "-----",
                    false,
                    new Date(),
                    null,
                    "test",
                    "testLink"
            );
            entityManager.persist(noteBig);

            LOG.info(noteBig.toString());
            assertNotEquals(0, noteBig.getId());

            entityManager.getTransaction().commit();

        } catch (Throwable throwable) {
            entityManager.getTransaction().rollback();
            throw throwable;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}