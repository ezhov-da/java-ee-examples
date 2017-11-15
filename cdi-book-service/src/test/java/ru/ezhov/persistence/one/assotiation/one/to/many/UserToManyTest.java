package ru.ezhov.persistence.one.assotiation.one.to.many;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Ignore
public class UserToManyTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserToManyTest.class.getName());

    @Test
    public void selectAll() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            List<UserToMany> list = entityManager.createQuery(
                    "select n FROM UserToManyColumn n",
                    UserToMany.class
            ).getResultList();

            LOG.info("list: {}", list);
            assertNotEquals(0, list.size());

        } finally {
            entityManager.close();
            entityManagerFactory.close();

        }
    }
}