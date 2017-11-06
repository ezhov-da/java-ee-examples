package ru.ezhov.ejb;

import org.junit.Test;
import ru.ezhov.cdi.Book;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BookEJBTest {
    @Test
    public void findBook() throws Exception {
        Map<String, Object> properties = new HashMap<>();
        properties.put(EJBContainer.MODULES, new File("target/classes"));

        try (EJBContainer container = EJBContainer.createEJBContainer(properties)) {
            Context context = container.getContext();

            Book book = new Book();

            book.setTitle("EZHOV-TEST");
            book.setDescription("WOWOW");
            book.setNumber("5023653650156");
            book.setPrice(45.6);

            BookEJB bookEJB = (BookEJB) context.lookup("java:global/classes/BookEJB");

            bookEJB.create(book);

            assertNotNull(book.getId());
        }
    }
}