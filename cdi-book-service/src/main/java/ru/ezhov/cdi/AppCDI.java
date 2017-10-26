package ru.ezhov.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 * Hello world!
 */
public class AppCDI {
    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize();
        BookService bookService = weldContainer.instance().select(BookService.class).get();
        bookService.createBook("test", 12.12F, "wowowowowow");
        bookService.createBook("test", 12.12F, "wowowowowow");
        bookService.createBook("test", 12.12F, "wowowowowow");
        bookService.createBook("test", 12.12F, "wowowowowow");
    }
}
