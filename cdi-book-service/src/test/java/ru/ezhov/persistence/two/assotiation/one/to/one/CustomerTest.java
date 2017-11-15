package ru.ezhov.persistence.two.assotiation.one.to.one;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Ignore
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


            for(Customer customer: list){
                LOG.info("------------->");
                LOG.info(customer.toString());
                LOG.info(customer.getAddress().toString());
                LOG.info("<-------------");
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}