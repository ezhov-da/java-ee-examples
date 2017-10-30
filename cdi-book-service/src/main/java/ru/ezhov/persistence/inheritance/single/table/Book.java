package ru.ezhov.persistence.inheritance.single.table;

import javax.persistence.Entity;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
public class Book extends Item {
    private String author;

    public Book(String author) {
        this.author = author;
    }

    public Book(String name, String author) {
        super(name);
        this.author = author;
    }
}
