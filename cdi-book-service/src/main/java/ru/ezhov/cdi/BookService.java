package ru.ezhov.cdi;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * Created by rrnezh on 26.10.2017.
 */
@Loggable
public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    @Inject
    private Event<Book> bookEventAdd;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description, numberGenerator.generateNumber());
        bookEventAdd.fire(book);
        return book;
    }
}
