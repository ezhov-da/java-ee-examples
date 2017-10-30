package ru.ezhov.persistence.one.assotiation.one.to.many.from.column.key;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ezhov.persistence.one.assotiation.one.to.many.UserToMany;
import ru.ezhov.persistence.one.assotiation.one.to.many.UserToManyTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 29.10.2017.
 */
public class UserToManyColumnTest {

    private static final Logger LOG = LoggerFactory.getLogger(UserToManyTest.class.getName());

    @Test
    public void selectAll() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            List<UserToManyColumn> list = entityManager.createQuery(
                    "select n FROM UserToManyColumn n",
                    UserToManyColumn.class
            ).getResultList();

            LOG.info("list: {}", list);
            assertNotEquals(0, list.size());

        } finally {
            entityManager.close();
            entityManagerFactory.close();

        }
    }
}