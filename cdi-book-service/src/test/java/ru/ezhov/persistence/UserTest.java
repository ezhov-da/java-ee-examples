package ru.ezhov.persistence;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 28.10.2017.
 */
public class UserTest {
    private static final Logger LOG = LoggerFactory.getLogger(UserTest.class.getName());

    @Test
    public void selectAll() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            List<User> list = entityManager.createQuery(
                    "select n FROM User n",
                    User.class
            ).getResultList();

            LOG.info("list: {}", list);
            assertTrue(!list.isEmpty());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}