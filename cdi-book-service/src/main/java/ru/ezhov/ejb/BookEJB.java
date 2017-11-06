package ru.ezhov.ejb;

import ru.ezhov.cdi.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BookEJB {

    @PersistenceContext(unitName = "ru.ezhov")
    private EntityManager entityManager;

    public List<Book> findBook() {
        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }

    public void create(Book book) {
        entityManager.persist(book);
    }
}
