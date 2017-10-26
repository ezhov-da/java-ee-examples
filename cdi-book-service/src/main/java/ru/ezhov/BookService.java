package ru.ezhov;

import javax.inject.Inject;

/**
 * Created by rrnezh on 26.10.2017.
 */
@Loggable
public class BookService {
    @Inject
    @ThirteenDigits
    private NumberGenerator numberGenerator;

    public Book createBook(String title, Float price, String description) {
        Book book = new Book(title, price, description);
        book.setNumber(numberGenerator.generateNumber());
        return book;
    }
}
