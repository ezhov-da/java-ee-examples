package ru.ezhov.persistence.inheritance.table.per.clazz;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by rrnezh on 29.10.2017.
 */
@Entity
@Table(name = "T_E_INHERITANCE_TABLE_PER_CLASS_BOOK")
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
