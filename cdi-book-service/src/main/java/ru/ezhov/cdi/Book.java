package ru.ezhov.cdi;

import javax.persistence.*;

/**
 * Created by rrnezh on 26.10.2017.
 */

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private double price;
    private String description;
    private String number;

    public Book() {
    }

    public Book(String title, double price, String description, String number) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
