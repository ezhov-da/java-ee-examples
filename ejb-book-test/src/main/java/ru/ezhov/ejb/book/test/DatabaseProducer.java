package ru.ezhov.ejb.book.test;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DatabaseProducer {
    @Produces
    @PersistenceContext(unitName = "ru.ezhov")
    private EntityManager entityManager;
}
