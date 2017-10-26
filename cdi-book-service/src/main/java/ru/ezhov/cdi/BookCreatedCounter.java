package ru.ezhov.cdi;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

/**
 * Created by rrnezh on 26.10.2017.
 */
@Singleton
@Loggable
public class BookCreatedCounter {
    int i;

    @Inject
    private Logger logger;

    public void createCount(@Observes Book book) {
        logger.info("Book added: [" + ++i + "] - " + book);
    }
}
