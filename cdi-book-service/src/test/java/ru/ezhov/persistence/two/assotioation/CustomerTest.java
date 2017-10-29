package ru.ezhov.persistence.two.assotioation;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.ezhov.persistence.note.NoteDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 29.10.2017.
 */
public class CustomerTest {
    private static final Logger LOG = LoggerFactory.getLogger(CustomerTest.class.getName());

    @Test
    public void selectAll() throws Exception {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            List<Customer> list = entityManager.createQuery(
                    "select n FROM Customer n",
                    Customer.class
            ).getResultList();

            LOG.info("list: {}", list);


            Customer customer = new Customer();
            customer.setFirstName("WOWOWOWOW");

            Address address = new Address();
            address.setCustomer(customer);
            address.setStreet("STREET");
            customer.setAddress(address);

            try {

                entityManager.getTransaction().begin();
                entityManager.persist(customer);
                entityManager.persist(address);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                entityManager.getTransaction().rollback();
            }

            list = entityManager.createQuery(
                    "select n FROM Customer n",
                    Customer.class
            ).getResultList();

            LOG.info("list: {}", list);
            assertTrue(!list.isEmpty());

        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}