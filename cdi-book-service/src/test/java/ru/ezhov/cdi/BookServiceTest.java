package ru.ezhov.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by rrnezh on 28.10.2017.
 */
@Ignore
public class BookServiceTest {
    private static final Logger LOG = LoggerFactory.getLogger(BookServiceTest.class.getName());

    @Test
    public void start() throws Exception {
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();
        BookService bookService = weldContainer.instance().select(BookService.class).get();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();

        Book book;

        try {

            book = bookService.createBook("test", 12.12F, "wowowowowow");

            Set<ConstraintViolation<Book>> constraintViolationSet = validator.validate(book);
            assertFalse(constraintViolationSet.isEmpty());
            if (!constraintViolationSet.isEmpty()) {
                constraintViolationSet.forEach(cv -> LOG.warn(cv.getMessage()));
            }

            book = bookService.createBook("test", 12.12F, "wowowowowow");
            assertNotNull(book);
            book = bookService.createBook("test", 12.12F, "wowowowowow");
            assertNotNull(book);
        } finally {
            validatorFactory.close();
        }
    }
}