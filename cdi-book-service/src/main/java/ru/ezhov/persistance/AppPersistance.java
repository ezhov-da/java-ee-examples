package ru.ezhov.persistance;

import ru.ezhov.cdi.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rrnezh on 26.10.2017.
 */
public class AppPersistance {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(new Book("test", 567, "wowowowowowo", "fasdf"));
            entityManager.persist(new Book("2414", 567, "wowowowowowo", "sfsf"));
            entityManager.persist(new Book("qwtqwetqwt", 567, "wowowowowowo", "sfsfagag"));
            entityManager.getTransaction().commit();
        } catch (Throwable throwable) {
            entityManager.getTransaction().rollback();
            throwable.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
