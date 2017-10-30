package ru.ezhov.persistence.entity.manipulation;

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
public class CustomerManipulationTest {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerManipulationTest.class.getName());

    @Test
    public void insert() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CustomerManipulation customerManipulation =
                new CustomerManipulation("Ezhov", "Denis", "test@mail.ru");

        AddressManipulation addressManipulation =
                new AddressManipulation("1", "1", "1", "1");

        customerManipulation.setAddressManipulation(addressManipulation);

        try {
            entityManager.getTransaction().begin();

            entityManager.persist(customerManipulation);
            entityManager.persist(addressManipulation);

            entityManager.getTransaction().commit();

            assertNotNull(customerManipulation.getId());
            assertNotNull(addressManipulation.getId());


            assertTrue(entityManager.contains(customerManipulation));

            entityManager.clear();

            customerManipulation.setFirstName("wow");
            entityManager.getTransaction().begin();
            customerManipulation = entityManager.merge(customerManipulation);
            entityManager.getTransaction().commit();

            assertEquals("wow", customerManipulation.getFirstName());


            entityManager.getTransaction().begin();

            entityManager.remove(customerManipulation);

            entityManager.getTransaction().commit();

            assertFalse(entityManager.contains(customerManipulation));
        } catch (Throwable ex) {
            entityManager.getTransaction().rollback();
            throw ex;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}